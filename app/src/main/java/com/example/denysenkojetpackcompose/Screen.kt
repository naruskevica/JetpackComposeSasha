package com.example.denysenkojetpackcompose

sealed class Screen(val route: String) {
    object MainCartoonScreen: Screen("main_car_screen")
    object DetailCartoonScreen: Screen("detail_car_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

