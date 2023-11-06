package com.example.nonameapp

enum class FoodCategories(val sectionName: String, val drawableResource: Int) {
    SNACKS("Snacks", R.drawable.chip_snacks),
    SALADS("Salads", R.drawable.chip_salad),
    SOUPS("Soups", R.drawable.chip_soup),
    ROMAN_PIZZA("Roman pizza", R.drawable.chip_pizza),
    JOSPER("Josper", R.drawable.chip_pizza),
    OTHER("Other", R.drawable.chip_pizza),
    PRIME("Prime", R.drawable.chip_pizza),
    BURGERS("Burgers", R.drawable.chip_burger),
    SIDE_DISHES("Side dishes", R.drawable.chip_sd),
    SAUCES("Sauces", R.drawable.chip_sauce),
    DESSERTS("Desserts", R.drawable.chip_dessert),
    DRINKS("Drinks", R.drawable.chip_drink),
    ALCOHOL("Alcohol", R.drawable.chip_alco)
}