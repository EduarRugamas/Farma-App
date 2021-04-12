package com.thedevexperto.farma_app.Auth

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thedevexperto.farma_app.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val bunled = intent.extras
        val nombre_usuario = bunled?.get("user_name")

        hola.text = "Bienvenido/a usuario ${nombre_usuario.toString()}"
    }
}