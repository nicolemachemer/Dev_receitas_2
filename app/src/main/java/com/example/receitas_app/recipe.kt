package com.example.receitas_app

data class Receita(
    val nome: String,
    val imagem: Int,
    val ingredientes: String,
    val modoDePreparo: String
)

// Ao criar a lista:
val receitas = listOf(
    Receita(
        "Bolo de Chocolate",
        R.drawable.bolo_chocolate_background,
        "1 xícara de farinha\n2 ovos\n1 colher de açúcar",
        "Misture tudo e leve ao forno por 30 minutos."
    ),
    Receita(
        "Torta de Limão",
        R.drawable.torta_limao_background,
        "1 lata de leite condensado\n1 limão\n1 pacote de biscoito",
        "Faça a base com os biscoitos e espalhe o creme por cima. Resfrie por 2 horas."
    ),
    Receita(
        "Pizza Caseira",
        R.drawable.pizza_caseira_background,
        "1 xícara de água morna\n2 colheres de sopa de azeite\n2 xícaras de farinha de trigo\n1 colher de chá de sal\n1 sachê de fermento biológico seco\nMolho de tomate\nQueijo e recheios a gosto",
        "1. Misture a água morna, azeite, fermento e sal.\n2. Acrescente a farinha aos poucos, formando uma massa lisa.\n3. Deixe a massa descansar por 30 minutos.\n4. Abra a massa, espalhe molho de tomate e recheios.\n5. Asse em forno pré-aquecido a 200°C por 20 minutos."
    )
)
