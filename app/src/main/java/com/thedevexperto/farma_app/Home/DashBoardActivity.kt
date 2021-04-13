package com.thedevexperto.farma_app.Home

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.thedevexperto.farma_app.Auth.LoginActivity
import com.thedevexperto.farma_app.R
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashBoardActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val correo = FirebaseAuth.getInstance().currentUser?.email
        text_userName.text = correo

        btn_cerrar_sesion.setOnClickListener {
            cerrar_sesion()
        }

        layout_medicamentos.setOnClickListener {
            val nav_intent = Intent(this, MedicamentosActivity::class.java)
            startActivity(nav_intent)
        }

    }

    private fun cerrar_sesion(){

        val intent = Intent(this,LoginActivity::class.java).apply {
            FirebaseAuth.getInstance().signOut()
        }
        startActivity(intent)

    }

}