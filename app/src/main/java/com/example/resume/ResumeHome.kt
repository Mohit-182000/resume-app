package com.example.resume

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.actions.FloatAction
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ResumeHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume_home)
        this.supportActionBar?.hide()
        window.statusBarColor = Color.WHITE

        var view_detail_cv = findViewById<Button>(R.id.view_detail_cv)
        var create_resume = findViewById<FloatingActionButton>(R.id.create_resume)

        view_detail_cv.setOnClickListener {
            startActivity(Intent(this,ResumeDetail::class.java));
        }

        create_resume.setOnClickListener {
            startActivity(Intent(this,ResumeCreate::class.java));
        }
    }
}