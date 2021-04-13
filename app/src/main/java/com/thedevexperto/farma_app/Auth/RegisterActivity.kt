package com.thedevexperto.farma_app.Auth

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.thedevexperto.farma_app.R
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_registro.setOnClickListener {
            val correo = edt_email.text.toString()
            val contra = edt_password.text.toString()

            create_user(correo,contra)
        }

        btn_inicio_sesion.setOnClickListener {
            Login()
        }

    }


    private fun Login(){
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }

    private fun create_user(email:String,pass:String){
        if (email.isNotEmpty() && pass.isNotEmpty()){
            FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email,pass)
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            showAlertSuccess("Usuario creado correctamente",email)
                        } else{
                            showAlertError("Se ha producido un error al crear el usuario")
                        }
                    }
        }else {
            Toast.makeText(this, "Los campos son requeridos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showAlertError(texto_error:String?){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage(texto_error)
        builder.setPositiveButton("Aceptar", null)
        val dialog:AlertDialog =  builder.create()
        dialog.show()
    }
    private fun showAlertSuccess(texto_success:String?, email_user:String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Usuario creado con exito")
        builder.setMessage(texto_success)
        builder.setPositiveButton("Aceptar") { dialog, which ->
            showLogin(email_user)
        }
        val dialog:AlertDialog =  builder.create()
        dialog.show()
    }

    private fun showLogin(email:String){
        val nav_login = Intent(this, LoginActivity::class.java).apply {
            putExtra("user_name", email)
        }
        startActivity(nav_login)
    }


}