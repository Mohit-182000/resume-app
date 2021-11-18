package com.example.resume

import android.app.Service
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    lateinit var login_email : TextInputEditText
    lateinit var login_password : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        this.supportActionBar?.hide()
        window.statusBarColor = this.resources.getColor(R.color.loginStatusBarColor)

        val user = Firebase.auth.currentUser

        if (user != null) {
            startActivity(Intent(this,MainActivity::class.java))
        }

        var signUp = findViewById<TextView>(R.id.tv_signup)
        var btn_login = findViewById<TextView>(R.id.btn_login)
        var skip_login = findViewById<TextView>(R.id.skip_login)
        login_email = findViewById(R.id.et_login_email)
        login_password = findViewById(R.id.et_login_password)

        signUp.setOnClickListener {
            startActivity(Intent(this,SignupActivity::class.java))
            finish()
        }

        btn_login.setOnClickListener {
            var context = this
            var connectivity : ConnectivityManager? = null
            var info : NetworkInfo? = null

            connectivity = context.getSystemService(Service.CONNECTIVITY_SERVICE) as ConnectivityManager

            if ( connectivity != null) {
                info = connectivity!!.activeNetworkInfo
                if (info != null) {
                    if (info!!.state == NetworkInfo.State.CONNECTED) {
                        loginUser()
                    }
                }else{
                    SweetAlertDialog(this,SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Opps..")
                        .setContentText("You don't have internate connection")
                        .show()
                }
            }
        }

        skip_login.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

    private fun loginUser() {
        if(login_email.text.toString().isNotEmpty() && login_password.text.toString().isNotEmpty()){
            auth = Firebase.auth
            auth.signInWithEmailAndPassword(login_email.text.toString(), login_password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this,MainActivity::class.java))
                    } else {
                        SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Opps..")
                            .setContentText("wrong username and password")
                            .show()
                    }
                }
        }else{
            Toast.makeText(this,"Email and password cannot be empty",Toast.LENGTH_LONG).show()
        }
    }
}