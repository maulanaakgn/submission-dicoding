package com.maulanaakgn.submissiondicoding_azkimaulanaassariy

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logoSplash: ImageView = findViewById(R.id.img_logo)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DELAY_TIME)
    }

    companion object {
        private const val SPLASH_DELAY_TIME = 1000L
    }
}