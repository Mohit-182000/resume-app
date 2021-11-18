package com.example.resume

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = this.resources.getColor(R.color.colorPrimaryDark)

        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        supportActionBar?.setCustomView(R.layout.activity_custome_title_bar)

        var create_resume = findViewById<CardView>(R.id.create_resume)
        var resume_download = findViewById<CardView>(R.id.resume_downloads)
        var share_app = findViewById<CardView>(R.id.share_app)

        share_app.setOnClickListener {
            ShareApp()
        }

        create_resume.setOnClickListener {
            startActivity(Intent(this,ResumeHome::class.java));
        }

        resume_download.setOnClickListener {
            startActivity(Intent(this,DownloadedResume::class.java));
        }
    }

    private fun ShareApp() {
        Toast.makeText(this,"Share App Code",Toast.LENGTH_LONG).show()
    }
}