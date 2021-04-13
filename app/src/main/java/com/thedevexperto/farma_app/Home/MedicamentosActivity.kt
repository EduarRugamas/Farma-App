package com.thedevexperto.farma_app.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.thedevexperto.farma_app.Data.ListMedicamentos
import com.thedevexperto.farma_app.R

class MedicamentosActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicamentos)


        Firebase.firestore.collection("Medicamentos")
            .get()
            .addOnSuccessListener { result ->
                val list_medicamentos = ArrayList<ListMedicamentos>()
                for (document in result){
                    Log.d("result", document.toString())
                    val lista = document.toObject(ListMedicamentos::class.java)
                    list_medicamentos.add(lista)
                }

                Log.d("result2",list_medicamentos.toString())

            }.addOnFailureListener { exception ->
                Log.d("error", "Error getting documents.", exception)
            }
    }
}