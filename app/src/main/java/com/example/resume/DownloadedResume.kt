package com.example.resume

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DownloadedResume : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_downloaded_resume)
        this.supportActionBar?.hide()
        window.statusBarColor = Color.WHITE
    }
}