package com.example.receitas_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Listareceita2Activity : AppCompatActivity() {

                private lateinit var rvReceitas: RecyclerView
                private val receitas = mutableListOf(
                    Receita("Bolo de Chocolate", R.drawable.bolo_chocolate_background),
                    Receita("Torta de Limão", R.drawable.torta_limao_background),
                    Receita("Pizza Caseira", R.drawable.pizza_caseira_background)
                )

                // Configuração do adaptador com o clique
                val adapter = ReceitaAdapter(receitas) { receita ->
                    // ESTE É O LOCAL ONDE VOCÊ ADICIONA O CÓDIGO DA INTENT
                    val intent = Intent(this, RecipeDetailsActivity::class.java)
                    intent.putExtra("recipe_name", receita.nome) // Nome da receita
                    intent.putExtra("recipe_image", receita.imagem) // Imagem da receita
                    intent.putExtra(
                        "recipe_ingredients",
                        "1 xícara de farinha\n2 ovos\n1 colher de açúcar" // Ingredientes fixos (exemplo)
                    )
                    intent.putExtra(
                        "recipe_preparation",
                        "Misture tudo e leve ao forno por 30 minutos." // Modo de preparo fixo (exemplo)
                    )
                    startActivity(intent) // Abre a tela de detalhes da receita
                }

                override fun onCreate(savedInstanceState: Bundle?) {
                    super.onCreate(savedInstanceState)
                    setContentView(R.layout.activity_listareceita2)

                    rvReceitas = findViewById(R.id.rvReceitas)
                    rvReceitas.layoutManager = LinearLayoutManager(this)
                    rvReceitas.adapter = ReceitaAdapter(receitas) { receita ->
                        val intent = Intent(this, RecipeDetailsActivity::class.java)
                        intent.putExtra("receita_nome", receita.nome)
                        intent.putExtra("receita_imagem", receita.imagem)
                        startActivity(intent)
                    }
                }
            }



