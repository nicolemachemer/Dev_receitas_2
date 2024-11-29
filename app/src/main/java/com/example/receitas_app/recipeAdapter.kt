package com.example.receitas_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReceitaAdapter(
    private var receitas: MutableList<Receita>,
    private val onItemClick: (Receita) -> Unit
) : RecyclerView.Adapter<ReceitaAdapter.ReceitaViewHolder>() {

    inner class ReceitaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nome: TextView = view.findViewById(R.id.tvNomeReceita)
        val imagem: ImageView = view.findViewById(R.id.recipeRecyclerView)

        fun bind(receita: Receita) {
            nome.text = receita.nome
            imagem.setImageResource(receita.imagem)
            itemView.setOnClickListener { onItemClick(receita) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceitaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_itemrecipe, parent, false)
        return ReceitaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReceitaViewHolder, position: Int) {
        holder.bind(receitas[position])
    }

    override fun getItemCount() = receitas.size

    // Método para atualizar a lista de receitas
    fun updateList(novasReceitas: List<Receita>) {
        receitas.clear()
        receitas.addAll(novasReceitas)
        notifyDataSetChanged()
    }
}
