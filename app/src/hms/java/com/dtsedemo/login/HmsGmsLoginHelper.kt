package com.dtsedemo.login

import android.content.Context
import android.content.Intent
import android.util.Log
import com.huawei.hms.support.hwid.HuaweiIdAuthManager
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper
import com.huawei.hms.support.hwid.result.AuthHuaweiId
import java.lang.Exception

class HmsGmsLoginHelper(
    context: Context,
    private val loginHelperCallback: LoginHelperCallback
) : LoginHelper {

    private val huaweiIdAuthParams =
        HuaweiIdAuthParamsHelper(HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM).setIdToken()
            .createParams()

    private val mHuaweiIdAuthService =
        HuaweiIdAuthManager.getService(context, huaweiIdAuthParams)

    private fun getLogTag() = "HmsLoginHelper"

    override fun getSignInIntent() = mHuaweiIdAuthService.signInIntent

    override fun getRequestCode() = 1004 // Random request code for intent call

    override fun onSignInClick() {
        loginHelperCallback.redirectToSignIn(getSignInIntent(),getRequestCode())
    }

    override fun onDataReceived(requestCode: Int, data: Intent?) {
        if(getRequestCode() == requestCode){
            val task = HuaweiIdAuthManager.parseAuthResultFromIntent(data)
            handleHuaweiIdSignInResult(task)
        }
    }

    private fun handleHuaweiIdSignInResult(completedTask: com.huawei.hmf.tasks.Task<AuthHuaweiId>) {
        if (completedTask.isSuccessful) {
            val huaweiAccount = completedTask.result
            loginHelperCallback.onLoginSuccess(huaweiAccount.displayName)
            Log.i(getLogTag(), huaweiAccount.displayName)
        } else {
            loginHelperCallback.onLoginError(completedTask.exception ?: Exception("Login Failed"))
            Log.e(getLogTag(),
                "${getLogTag()}=" + (completedTask.exception as? com.huawei.hms.common.ApiException)?.statusCode
            )
        }
    }

    override fun logOut() {
        mHuaweiIdAuthService.signOut().addOnSuccessListener {
            loginHelperCallback.onLogOutSuccess()
        }.addOnFailureListener {
            loginHelperCallback.onLogOutFail()
        }
    }

    override fun revokeAccess() {
        mHuaweiIdAuthService.cancelAuthorization()
    }

}