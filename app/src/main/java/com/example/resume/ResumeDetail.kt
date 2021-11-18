package com.example.resume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.airbnb.lottie.LottieAnimationView

class ResumeDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume_detail)
        this.supportActionBar?.hide()
        window.statusBarColor = this.resources.getColor(R.color.resumeHomeColor)

        var create_resume_loader = findViewById<LottieAnimationView>(R.id.create_resume_loader)
        var linerarLayout1 = findViewById<LinearLayout>(R.id.linearLayout2)
        var linerarLayout2 = findViewById<LinearLayout>(R.id.topbar)
        var scrollbar = findViewById<ScrollView>(R.id.scrollbar)
        var coordinatorLayout2 = findViewById<CoordinatorLayout>(R.id.coordinatorLayout2)

        linerarLayout1.visibility = View.GONE
        linerarLayout2.visibility = View.GONE
        scrollbar.visibility = View.GONE
        coordinatorLayout2.visibility = View.GONE

        Handler().postDelayed({
            create_resume_loader.visibility = View.GONE
            linerarLayout1.visibility = View.VISIBLE
            linerarLayout2.visibility = View.VISIBLE
            scrollbar.visibility = View.VISIBLE
            coordinatorLayout2.visibility = View.VISIBLE
        },5000)
    }
}