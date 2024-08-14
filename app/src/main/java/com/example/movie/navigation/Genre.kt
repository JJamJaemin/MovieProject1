package com.example.movie.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movie.ui.theme.MovieTheme

//장르 고르는 화면

var genreList : List<String> = listOf("Comedy", "Horror", "Romance", "Action", "Drama", "Fantasy", "Musical", "Thriller", "Western", "Animation", "Crime", "Historical Fiction", "Science fiction", "Adventure", "Documentary")

@Composable
fun GenrePickScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ){
        GenrePick(genreList = genreList)
    }
}

@Composable
fun GenrePick(modifier: Modifier = Modifier, genreList: List<String>) {
    LazyHorizontalStaggeredGrid(
        rows = StaggeredGridCells.Fixed(3),
        modifier = Modifier.height(130.dp)
    ) {
        items(genreList.size) { item ->
            Genre(name = genreList[item])
        }
    }
}

@Composable
fun Genre(modifier: Modifier = Modifier, name:String) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
    ) {
        Box (
            modifier = Modifier.background(Color.Black)
        ){
            Button(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF70757B),
                    contentColor = Color.Black
                )
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Prev1() {
    Genre(name = "hello")
}

@Preview(showBackground = true)
@Composable
private fun Prev() {
    MovieTheme {
        GenrePick(genreList = genreList)
    }
}

@Preview
@Composable
private fun Prev2() {
    GenrePickScreen()
}