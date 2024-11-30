package com.example.receitas_app

import android.os.Bundle
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class pesquisa2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Adicione no onCreate
        val searchView: SearchView = findViewById(R.id.Busca_Pesquisa)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList =
                    receitas.filter { it.nome.contains(newText ?: "", ignoreCase = true) }
                (RecyclerView.adapter as ReceitaAdapter).apply {
                    receitas.clear()
                    receitas.addAll(filteredList)
                    notifyDataSetChanged()
                }
                return true

                )
        }
    }
}

