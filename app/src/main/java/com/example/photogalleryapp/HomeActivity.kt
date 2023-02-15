package com.example.photogalleryapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.gridunsplash.presentation.theme.GridUnsplashTheme
import com.example.photogalleryapp.overview.PictureGridScreen
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridUnsplashTheme{
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PictureGridScreen()
                }
            }
        }
    }




}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GridUnsplashTheme {
    }
}

