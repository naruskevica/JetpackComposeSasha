package com.example.denysenkojetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainCartoonScreen.route) {
        composable(route = Screen.MainCartoonScreen.route) {
            MainCartoonScreen(navController = navController)
        }
        composable(
            route = Screen.DetailCartoonScreen.route + "/{cartoon_id}",
            arguments = listOf(
                navArgument("cartoon_id") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            DetailCartoonScreen(id = entry.arguments?.getString("cartoon_id"))
        }
    }
}

@Composable
fun MainCartoonScreen(navController: NavController) {
    LazyColumn {
        itemsIndexed(
            CatroonData().anime.value
        ) { index, item ->
            MainActivityComposable(item, navController)
        }
    }
}

@Composable
fun DetailCartoonScreen(id: String?) {
    if (id != null) {
        val car = CatroonData().getById(id)
        Column {
            Image(
                painter = painterResource(id = car.picture),
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            Divider(Modifier.padding(15.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) { append("Name: ") }
                    append(car.name)
                },
            )
            Divider(Modifier.padding(15.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) { append("Description: ") }
                    append(car.description)
                },
            )
            Divider(Modifier.padding(15.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) { append("studio: ") }
                    append(car.studio)
                },
            )
            Divider(Modifier.padding(15.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) { append("Year: ") }
                    append(car.year.toString())
                },
            )
        }
    }
}
