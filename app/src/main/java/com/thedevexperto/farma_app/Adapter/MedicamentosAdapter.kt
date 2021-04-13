package com.thedevexperto.farma_app.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thedevexperto.farma_app.Data.ListMedicamentos
import com.thedevexperto.farma_app.R
import kotlinx.android.synthetic.main.item_medicinas.view.*

class MedicamentosAdapter constructor(
    private val lista_medicinas:ArrayList<ListMedicamentos>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_medicinas,parent,false)

        return MedicinasViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val medicinas_lista: ListMedicamentos = lista_medicinas[position]
        (holder as MedicinasViewHolder).bind(medicinas_lista)
    }

    override fun getItemCount(): Int = lista_medicinas.size

    inner class MedicinasViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(medicinas:ListMedicamentos){
                itemView.nombre_medicina.text = medicinas.nombre
                itemView.precio_medicina.text = medicinas.precio
                Glide.with(itemView.context).load(medicinas.imagen).into(itemView.imagen_medicina)
        }
    }

}