package com.dtsedemo.login

import android.content.Context
import android.content.Intent
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

class HmsGmsLoginHelper(
    context: Context,
    private val loginHelperCallback: LoginHelperCallback
) : LoginHelper{

    private val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()

    private val mGoogleSignInClient = GoogleSignIn.getClient(context,googleSignInOptions    )

    override fun onDataReceived(requestCode: Int, data: Intent?) {
        if(getRequestCode() == requestCode){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleGoogleSignInResult(task)
        }
    }

    private fun getLogTag() = "GOOGLE_SIGN_IN"

    override fun getSignInIntent() = mGoogleSignInClient.signInIntent

    override fun getRequestCode() = 2020 // // Random request code for intent call

    override fun onSignInClick() {
        loginHelperCallback.redirectToSignIn(getSignInIntent(),getRequestCode())
    }

    private fun handleGoogleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val accountId = account?.id
            if (account != null && accountId != null) {
                loginHelperCallback.onLoginSuccess(accountId)
            }

        } catch (e: ApiException) {
            Log.e(getLogTag(), "${getLogTag()}:failed code=" + e.statusCode)
            loginHelperCallback.onLoginError(e)
        }
    }

    override fun logOut() {
        mGoogleSignInClient.signOut().addOnSuccessListener {
            loginHelperCallback.onLogOutSuccess()
        }.addOnFailureListener {
            loginHelperCallback.onLogOutFail()
        }
    }

    override fun revokeAccess() {
        mGoogleSignInClient.revokeAccess()
    }

}