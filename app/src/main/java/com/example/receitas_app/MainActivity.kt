package com.example.receitas_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.SearchView

class MainActivity : AppCompatActivity() {
    lateinit var user: EditText
    lateinit var pass: EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user = findViewById(R.id.useID)
        pass = findViewById(R.id.Password)
        loginButton = findViewById(R.id.button)

        loginButton.setOnClickListener {
            if (user.text.toString().equals("Nicole") && pass.text.toString().equals("1234"))
                Toast.makeText(this, "Foi!", Toast.LENGTH_LONG).show()
        }
    }

    class MainActivity : AppCompatActivity() {

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
            setContentView(R.layout.activity_main)

            rvReceitas = findViewById(R.id.recipeRecyclerView)
            rvReceitas.layoutManager = LinearLayoutManager(this)
            rvReceitas.adapter = ReceitaAdapter(receitas) { receita ->
                val intent = Intent(this, DetalhesActivity::class.java)
                intent.putExtra("receita_nome", receita.nome)
                intent.putExtra("receita_imagem", receita.imagem)
                startActivity(intent)
            }
        }
    }

    // Adicione no onCreate
    val searchView: SearchView = findViewById(R.id.Busca_Pesquisa)

    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            val filteredList = receitas.filter { it.nome.contains(newText ?: "", ignoreCase = true) }
            (recipeRecyclerView.adapter as ReceitaAdapter).apply {
                receitas.clear()
                receitas.addAll(filteredList)
                notifyDataSetChanged()
            }
            return true
        }
    })












// Codigo velho
    class MainActivity : AppCompatActivity() {
        private lateinit var searchEditText: EditText
        private lateinit var recipesAdapter: ReceitaAdapter
        private lateinit var recipesList: List<String>
        private lateinit var filteredRecipesList: MutableList<String>


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_pesquisa)
            searchEditText = findViewById(R.id.searchEditText)

            searchEditText = findViewById(R.id.searchEditText)
            val recyclerView: RecyclerView = findViewById(R.id.recipeRecyclerView)

            // Exemplo de lista de receitas
            recipesList = listOf("Pizza", "Bolo de Chocolate", "Massa Carbonara", "Torta de limão", "Pão")
            filteredRecipesList = recipesList.toMutableList()

            recipesAdapter = ReceitaAdapter(filteredRecipesList)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = recipesAdapter

            // Adicionando TextWatcher ao EditText
            searchEditText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    charSequence: CharSequence?,
                    start: Int,
                    before: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(
                    charSequence: CharSequence?,
                    start: Int,
                    before: Int,
                    after: Int
                ) {
                    filterRecipes(charSequence.toString())
                }

                override fun afterTextChanged(editable: Editable?) {}
            })
        }

        // Função para filtrar as receitas com base no texto digitado
        private fun filterRecipes(query: String) {
            filteredRecipesList.clear()
            if (query.isEmpty()) {
                filteredRecipesList.addAll(recipesList)
            } else {
                for (recipe in recipesList) {
                    if (recipe.contains(query, ignoreCase = true)) {
                        filteredRecipesList.add(recipe)
                    }
                }
            }
            recipesAdapter.notifyDataSetChanged() // Atualiza o RecyclerView com a lista filtrada
        }
    }
}

    class MainActivity : AppCompatActivity() {

        private lateinit var searchEditText: EditText
        private lateinit var recipesAdapter: recipeAdapter.RecipeAdapter
        private lateinit var recipesList: List<String>
        private lateinit var filteredRecipesList: MutableList<String>

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_recipedetails)

            val recipeList = listOf(
                recipe.Recipe(
                    "Bolo de Chocolate",
                    listOf("Farinha", "Cacau", "Ovos", "Leite", "Açúcar"),
                    "Misture todos os ingredientes...",
                    "https://example.com/cake.jpg"
            ),
                recipe.Recipe(
                    "Pão de Queijo",
                    listOf("Polvilho", "Queijo", "Ovos", "Leite"),
                    "Misture e asse os pães...",
                    "https://example.com/bread.jpg"
            )
        )

            val recyclerView: RecyclerView = findViewById(R.id.recipeRecyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)

            val recipeAdapter = recipeAdapter.RecipeAdapter(recipeList)
            recyclerView.adapter = recipeAdapter

        // Configurar o clique no item da lista
            recipeAdapter.setOnItemClickListener { recipe ->
            // Criar um Intent para ir para a RecipeDetailsActivity
                val intent = Intent(this, RecipeDetails.RecipeDetailsActivity::class.java).apply {
                // Passar os dados para a próxima Activity
                    putExtra("RECIPE_NAME", recipe.name)
                    putExtra("RECIPE_IMAGE", recipe.imageUrl)
                    putExtra("RECIPE_INGREDIENTS", ArrayList(recipe.ingredients))  // Converter a lista para ArrayList
                    putExtra("RECIPE_PREPARATION", recipe.preparationMethod)
            }
            startActivity(intent)
        }
    }
}


