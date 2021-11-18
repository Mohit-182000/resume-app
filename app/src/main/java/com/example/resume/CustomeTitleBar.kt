package com.example.resume

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class CustomeTitleBar : AppCompatActivity() {
    private lateinit var user : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custome_title_bar)

        var signOut = findViewById<Button>(R.id.signOut)
        user = FirebaseAuth.getInstance()

        signOut.setOnClickListener {
            if(user.currentUser != null){
                user.signOut()
                startActivity(Intent(this,LoginActivity::class.java))
            }
        }
    }
}