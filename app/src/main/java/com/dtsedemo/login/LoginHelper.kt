package com.dtsedemo.login

import android.content.Intent
import java.lang.Exception

interface LoginHelper{
    fun onDataReceived(requestCode : Int,data : Intent?)
    fun getSignInIntent() : Intent
    fun getRequestCode() : Int
    fun onSignInClick()
    fun logOut()
    fun revokeAccess()
}

interface LoginHelperCallback{
    fun onLoginSuccess(displayName : String)
    fun onLoginError(exception: Exception)
    fun onLogOutSuccess()
    fun onLogOutFail()
    fun redirectToSignIn(signInIntent : Intent, requestCode : Int)
}