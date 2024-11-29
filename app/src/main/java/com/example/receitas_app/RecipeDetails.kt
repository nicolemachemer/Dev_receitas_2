package com.example.receitas_app

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipedetails)

        // Obtendo as referências dos elementos no layout
        val recipeName: TextView = findViewById(R.id.recipeName)
        val recipeImage: ImageView = findViewById(R.id.recipeImage)
        val ingredients: TextView = findViewById(R.id.ingredients)
        val preparationMethod: TextView = findViewById(R.id.preparationMethod)

        // Recuperando os dados passados pela Intent
        val name = intent.getStringExtra("recipe_name")
        val imageRes = intent.getIntExtra("recipe_image", 0)
        val ingredientList = intent.getStringExtra("recipe_ingredients")
        val preparation = intent.getStringExtra("recipe_preparation")

        // Atualizando a tela com os dados da receita
        recipeName.text = name
        recipeImage.setImageResource(imageRes)
        ingredients.text = "Ingredientes:\n$ingredientList"
        preparationMethod.text = "Modo de Preparo:\n$preparation"
    }
}