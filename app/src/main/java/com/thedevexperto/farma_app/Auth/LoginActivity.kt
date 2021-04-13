package com.thedevexperto.farma_app.Auth

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.thedevexperto.farma_app.Home.DashBoardActivity
import com.thedevexperto.farma_app.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_Inicio_sesion.setOnClickListener {

            val bunled = intent.extras
            val nombre_usuario = bunled?.get("user_name")

            val email_usuario = correo.text.toString()
            val pass = contra.text.toString()

            inicio_sesion(nombre_usuario.toString(),email_usuario,pass)
        }

        btn_Registro.setOnClickListener {

        }
    }

    private fun inicio_sesion(name:String, correo:String, password:String){
        if (name.isNotEmpty() && correo.isNotEmpty() && password.isNotEmpty()){
            FirebaseAuth
                    .getInstance()
                    .signInWithEmailAndPassword(correo,password)
                    .addOnCompleteListener{
                        if (it.isSuccessful){
                            showHome(name)
                        }else {
                            Toast.makeText(this, "Usuario o contrasena incorrectos", Toast.LENGTH_LONG).show()
                        }
                    }
        }
    }

    private fun showHome(user_name:String){
        val nav = Intent(this, DashBoardActivity::class.java).apply {
            putExtra("user-name",user_name)
        }
        startActivity(nav)
    }
}