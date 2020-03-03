package com.dtsedemo.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.dtsedemo.BaseActivity
import com.dtsedemo.BuildConfig
import com.dtsedemo.R
import com.dtsedemo.push.TokenHelper
import java.lang.Exception

class LoginActivity : BaseActivity(),LoginHelperCallback{

    private lateinit var loginButton : Button

    private val loginHelper : LoginHelper by lazy {
        HmsGmsLoginHelper(this,this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        TokenHelper.getToken(this)
        loginButton = findViewById(R.id.activityLogin_button)
        setButtonToLogIn()
    }

    private fun setButtonToLogIn(){
        with(loginButton){
            text = if(BuildConfig.FLAVOR == "gms"){
                "Google SignIn"
            }else{
                "HuaweiId SignIn"
            }
            setOnClickListener { loginHelper.onSignInClick() }
        }
    }

    private fun setButtonToLogOut(){
        with(loginButton){
            text = if(BuildConfig.FLAVOR == "gms"){
                "Google LogOut"
            }else{
                "HuaweiId LogOut"
            }
            setOnClickListener { loginHelper.logOut() }
        }
    }

    override fun redirectToSignIn(signInIntent: Intent, requestCode: Int) {
        startActivityForResult(signInIntent, requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        loginHelper.onDataReceived(requestCode,data)
    }

    override fun onLoginSuccess(displayName: String) {
        Toast.makeText(this,"Welcome $displayName",Toast.LENGTH_LONG).show()
        setButtonToLogOut()
    }

    override fun onLogOutSuccess() {
        Toast.makeText(this,"LogOut success!",Toast.LENGTH_LONG).show()
        setButtonToLogIn()
    }

    override fun onLoginError(exception: Exception) {
        Toast.makeText(this,"Error -> ${exception.message ?:""}",Toast.LENGTH_LONG).show()
    }

    override fun onLogOutFail() {
        Toast.makeText(this,"Couldn't logOut.Try again",Toast.LENGTH_LONG).show()
    }
}