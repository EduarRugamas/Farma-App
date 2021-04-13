package com.thedevexperto.farma_app.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.thedevexperto.farma_app.Adapter.MedicamentosAdapter
import com.thedevexperto.farma_app.Data.ListMedicamentos
import com.thedevexperto.farma_app.R
import kotlinx.android.synthetic.main.activity_medicamentos.*

class MedicamentosActivity : AppCompatActivity() {

    val list_medicamentos = ArrayList<ListMedicamentos>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicamentos)

        Firebase.firestore.collection("Medicamentos")
            .get()
            .addOnSuccessListener { result ->

                for (document in result){
                    Log.d("result", document.toString())
                    val lista = document.toObject(ListMedicamentos::class.java)
                    list_medicamentos.add(lista)
                }

                recyclerview_medicamentos!!.layoutManager = LinearLayoutManager(this)
                val lista_adapter_medicamentos = MedicamentosAdapter(list_medicamentos)
                recyclerview_medicamentos.adapter = lista_adapter_medicamentos
                recyclerview_medicamentos.setHasFixedSize(true)

                Log.d("result2",list_medicamentos.toString())

            }.addOnFailureListener { exception ->
                Log.d("error", "Error getting documents.", exception)
            }
    }
}