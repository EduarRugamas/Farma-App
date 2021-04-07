package com.thedevexperto.farma_app.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thedevexperto.farma_app.Auth.LoginActivity
import com.thedevexperto.farma_app.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        android.os.Handler().postDelayed({
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        },5000)

    }
}