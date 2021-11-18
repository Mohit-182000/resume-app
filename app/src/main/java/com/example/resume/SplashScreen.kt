package com.example.resume

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.airbnb.lottie.LottieAnimationView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        this.supportActionBar?.hide()
        window.statusBarColor = Color.WHITE

        val animationView = findViewById<View>(R.id.animation_view) as LottieAnimationView
        animationView.setAnimation(R.raw.profile_searching)
        animationView.loop(true)
        animationView.playAnimation()

        Handler().postDelayed({
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        },5000)
    }
}