package com.example.denysenkojetpackcompose

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.denysenkojetpackcompose.model.Cartoon



@Composable
fun MainActivityComposable(anime: Cartoon, navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Gray
    )
    { ProfileCardComposable(anime, navController) }
}

@Composable
fun ProfileCardComposable(anime: Cartoon, navController: NavController) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(color = Color.White)
            .border(width = 2.dp, color = Color.Black)
            .padding(vertical = 10.dp)
            .clickable {
                navController.navigate(Screen.DetailCartoonScreen.withArgs(anime.id))
            }
    ) {
        Row(modifier = Modifier.height(intrinsicSize = IntrinsicSize.Max)) {
            ProfilePictureComposable(anime)
            ProfileContentComposable(anime)
        }
    }
}

@Composable
fun ProfilePictureComposable(anime: Cartoon) {
    Card(
        shape = CircleShape,
        border = BorderStroke(2.dp, color = Color.Green),
        modifier = Modifier.padding(horizontal = 5.dp),
        elevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = anime.picture),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
            contentDescription = ""
        )
    }
}

@Composable
fun ProfileContentComposable(anime: Cartoon) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(start = 8.dp),
        verticalArrangement = Arrangement.aligned(Alignment.CenterVertically)
    ) {
        Text(anime.name, fontWeight = FontWeight.Bold)
        Text(
            text = anime.studio,
        )
    }
}
