package com.thedevexperto.farma_app.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thedevexperto.farma_app.Auth.LoginActivity
import com.thedevexperto.farma_app.Auth.RegisterActivity
import com.thedevexperto.farma_app.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        android.os.Handler().postDelayed({
            startActivity(Intent(this,RegisterActivity::class.java))
            finish()
        },5000)

    }
}