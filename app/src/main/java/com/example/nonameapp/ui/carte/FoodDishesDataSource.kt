package com.example.nonameapp.ui.carte

import com.example.nonameapp.R

class FoodDishesDataSource {
    val listOfFoodDishes = listOf(
        FoodDish(
            id = 0,
            name = "Borsh",
            image = R.drawable.borsh,
            description = "Tasty borsh",
            price = 300
        ),
        FoodDish(
            id = 1,
            name = "Mushroom Soup",
            image = R.drawable.mushroom_soup,
            description = "Mmmm, mushrooms",
            price = 250
        ),
        FoodDish(
            id = 2,
            name = "Salman Fish",
            image = R.drawable.salmon_fish,
            description = "Дайте рыбов))",
            price = 350
        ),
        FoodDish(
            id = 3,
            name = "Vermicelli",
            image = R.drawable.vermicelli_with_mushrooms,
            description = "With mushrooms =)",
            price = 300
        ),
        FoodDish(
            id = 4,
            name = "Scrambled eggs",
            image = R.drawable.scrambled_eggs_and_toast,
            description = "And toast",
            price = 300
        ),
        FoodDish(
            id = 5,
            name = "Scrambled eggs",
            image = R.drawable.scrambled_eggs_with_something,
            description = "А что внутри?",
            price = 300
        ),
    )
}