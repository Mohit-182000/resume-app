package com.example.resume

import android.app.Service
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.resume.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {

    private lateinit var user: FirebaseAuth

    lateinit var email : TextInputEditText
    lateinit var password : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        this.supportActionBar?.hide()
        window.statusBarColor = this.resources.getColor(R.color.signupStatusBarColor)

        var tv_login = findViewById<TextView>(R.id.tv_login)
        email = findViewById(R.id.et_signup_email)
        password = findViewById(R.id.et_signup_password)
        var btn_signup = findViewById<Button>(R.id.btn_signup)

        user = FirebaseAuth.getInstance()

        tv_login.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }

        btn_signup.setOnClickListener {
            var context = this
            var connectivity : ConnectivityManager? = null
            var info : NetworkInfo? = null

            connectivity = context.getSystemService(Service.CONNECTIVITY_SERVICE) as ConnectivityManager

            if ( connectivity != null) {
                info = connectivity!!.activeNetworkInfo
                if (info != null) {
                    if (info!!.state == NetworkInfo.State.CONNECTED) {
                        registerUser()
                    }
                }else{
                    SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Opps..")
                        .setContentText("You don't have internate connection")
                        .show()
                }
            }
        }
    }

    private fun registerUser() {
        if(email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()){
            user.createUserWithEmailAndPassword(email.text.toString(),password.text.toString())
                .addOnCompleteListener(SignupActivity()){task ->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Your Account Created",Toast.LENGTH_LONG).show()
                        user.signInWithEmailAndPassword(email.text.toString(),password.text.toString())
                            .addOnCompleteListener{mTask->
                                if(mTask.isSuccessful){
                                    startActivity(Intent(this,MainActivity::class.java));
                                }else{
                                    SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                                        .setTitleText("Opps..")
                                        .setContentText(mTask.exception?.message)
                                        .show()
                                }
                            }
                    }else{
                        SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Opps..")
                            .setContentText(task.exception?.message)
                            .show()
                    }
                }
        }else{
            Toast.makeText(this,"Email and password cannot be empty",Toast.LENGTH_LONG).show()
        }
    }
}