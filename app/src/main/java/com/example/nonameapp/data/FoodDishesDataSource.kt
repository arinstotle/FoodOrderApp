package com.example.nonameapp.data

import com.example.nonameapp.Chip
import com.example.nonameapp.FoodCategories
import com.example.nonameapp.R
import com.example.nonameapp.data.model.CartDishUIModel
import com.example.nonameapp.ui.dishesmenu.FoodDishUIModel
import com.example.nonameapp.ui.dishesmenu.Ingredient

object FoodDishesDataSource {
    val listOfFoodDishes = listOf(
        FoodDishUIModel(
            id = "0",
            title = "Green Pasta",
            category = FoodCategories.PRIME,
            price = "300",
            description = "Tasty pasta",
            weight = "350",
            calories = "200",
            kilojoules = "1234",
            cookingTime = "45 мин",
            rating = "4.5",
            reviews = "x comments",
            proteins = "4",
            fats = "12",
            carbohydrates = "5",
            allergens = listOf<String>("Allerg1", "Allerg2", "Allerg3"),
            image = R.drawable.dish_green_pasta,
            ingredients = listOf(
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                )
            )
        ),
        FoodDishUIModel(
            id = "1",
            title = "Italian pasta",
            image = R.drawable.dish_italian_pasta,
            description = "Mmmm, italiano",
            price = "250",
            category = FoodCategories.PRIME,
            weight = "350",
            calories = "200",
            kilojoules = "1234",
            cookingTime = "45 мин",
            rating = "4.5",
            reviews = "x comments",
            proteins = "4",
            fats = "12",
            carbohydrates = "5",
            allergens = listOf<String>("Allerg1", "Allerg2", "Allerg3"),
            ingredients = listOf(
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                )
            )
        ),
        FoodDishUIModel(
            id = "2",
            title = "Meat salad",
            image = R.drawable.dish_meat_salad,
            description = "Дайте рыбов))",
            price = "350",
            category = FoodCategories.SALADS,
            weight = "350",
            calories = "200",
            kilojoules = "1234",
            cookingTime = "45 мин",
            rating = "4.5",
            reviews = "x comments",
            proteins = "4",
            fats = "12",
            carbohydrates = "5",
            allergens = listOf<String>("Allerg1", "Allerg2", "Allerg3"),
            ingredients = listOf(
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                )
            )
        ),
        FoodDishUIModel(
            id = "3",
            title = "Pork set",
            image = R.drawable.dish_pork_set,
            description = "With pork",
            price = "300",
            category = FoodCategories.PRIME,
            weight = "350",
            calories = "200",
            kilojoules = "1234",
            cookingTime = "45 мин",
            rating = "4.5",
            reviews = "x comments",
            proteins = "4",
            fats = "12",
            carbohydrates = "5",
            allergens = listOf<String>("Allerg1", "Allerg2", "Allerg3"),
            ingredients = listOf(
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                )
            )
        ),
        FoodDishUIModel(
            id = "4",
            title = "Green Pasta",
            category = FoodCategories.PRIME,
            price = "300",
            description = "Tasty pasta",
            weight = "350",
            calories = "200",
            kilojoules = "1234",
            cookingTime = "45 мин",
            rating = "4.5",
            reviews = "x comments",
            proteins = "4",
            fats = "12",
            carbohydrates = "5",
            allergens = listOf<String>("Allerg1", "Allerg2", "Allerg3"),
            image = R.drawable.dish_green_pasta,
            ingredients = listOf(
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                )
            )
        ),
        FoodDishUIModel(
            id = "5",
            title = "Italian pasta",
            image = R.drawable.dish_italian_pasta,
            description = "Mmmm, italiano",
            price = "250",
            category = FoodCategories.PRIME,
            weight = "350",
            calories = "200",
            kilojoules = "1234",
            cookingTime = "45 мин",
            rating = "4.5",
            reviews = "x comments",
            proteins = "4",
            fats = "12",
            carbohydrates = "5",
            allergens = listOf<String>("Allerg1", "Allerg2", "Allerg3"),
            ingredients = listOf(
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                ),
                Ingredient(
                    image = R.drawable.meat_ingredient,
                    title = "Meat",
                    subtitle = "340 g"
                )
            )
        )
    )
    val listOfChips = listOf(
        Chip(
            "Snacks",
            R.drawable.chip_snacks
        ),
        Chip(
            "Salads",
            R.drawable.chip_salad
        ),
        Chip(
            "Soups",
            R.drawable.chip_soup
        ),
        Chip(
            "Roman pizza",
            R.drawable.chip_pizza
        ),
        Chip(
            "Josper",
            R.drawable.chip_pizza
        ),
        Chip(
            "Other",
            R.drawable.chip_pizza
        ),
        Chip(
            "Prime",
            R.drawable.chip_pizza
        ),
        Chip(
            "Burgers",
            R.drawable.chip_burger
        ),
        Chip(
            "Side dishes",
            R.drawable.chip_sd
        ),
        Chip(
            "Sauces",
            R.drawable.chip_sauce
        ),
        Chip(
            "Desserts",
            R.drawable.chip_dessert
        ),
        Chip(
            "Drinks",
            R.drawable.chip_drink
        ),
        Chip(
            "Alcohol",
            R.drawable.chip_alco
        )
    )
    val listOfCartDishes = mutableListOf(
        CartDishUIModel(
            id = "0",
            title = "Green Pasta",
            image = R.drawable.dish_green_pasta,
            weight = "350",
            price = "390",
            quantity = 2,
        ),
        CartDishUIModel(
            id = "1",
            title = "Pork set",
            image = R.drawable.dish_pork_set,
            weight = "350",
            price = "300",
            quantity = 1,
        ),
        CartDishUIModel(
            id = "2",
            title = "Meat salad",
            image = R.drawable.dish_meat_salad,
            weight = "160",
            price = "250",
            quantity = 4,
        ),
        CartDishUIModel(
            id = "3",
            title = "Italian pasta",
            image = R.drawable.dish_italian_pasta,
            weight = "350",
            price = "300",
            quantity = 1,
        ),
        CartDishUIModel(
            id = "4",
            title = "Green Pasta",
            image = R.drawable.dish_green_pasta,
            weight = "350",
            price = "390",
            quantity = 2,
        ),
        CartDishUIModel(
            id = "5",
            title = "Pork set",
            image = R.drawable.dish_pork_set,
            weight = "350",
            price = "300",
            quantity = 1,
        ),
        CartDishUIModel(
            id = "6",
            title = "Meat salad",
            image = R.drawable.dish_meat_salad,
            weight = "160",
            price = "250",
            quantity = 4,
        ),
        CartDishUIModel(
            id = "7",
            title = "Italian pasta",
            image = R.drawable.dish_italian_pasta,
            weight = "350",
            price = "300",
            quantity = 1,
        )
    )

    val listOfCookingTime = listOf(
        Chip("Under 15 mins"),
        Chip("Under 30 mins"),
        Chip("Under 45 mins"),
        Chip("Under 60 mins")
    )

    val listOfDiet = listOf(
        Chip("Vegetarian"),
        Chip("Sugarless")
    )

    val listOfKitchen = listOf(
        Chip("Asian"),
        Chip("American"),
        Chip("Arabic"),
        Chip("BBQ"),
        Chip("British"),
        Chip("European")
    )

    val listOfSort = listOf(
        Chip("Price asc"),
        Chip("Price desc"),
        Chip("Rating"),
        Chip("todo")
    )
}