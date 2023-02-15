package com.example.photogalleryapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gridunsplash.presentation.theme.GridUnsplashTheme
import com.example.photogalleryapp.details.DetailsScreen
import com.example.photogalleryapp.overview.PictureGridScreen
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.setContext(this)
        setContent {
            GridUnsplashTheme{
                LoadPictureGridScreen()
            }
        }
    }

}

@Composable
private fun LoadPictureGridScreen(viewModel: PictureViewModel = hiltViewModel()) {
    val navController = rememberNavController()
    var canPop by remember { mutableStateOf(false) }
    navController.addOnDestinationChangedListener { controller, _, _ ->
        canPop = controller.previousBackStackEntry != null
    }

    val navigationIcon: (@Composable () -> Unit)? =
        if (canPop) {
            {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
            }
        } else {
            null
        }

    Surface(
        color = MaterialTheme.colors.background,
        content =  {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { PictureGridScreen(navController, viewModel) }
            composable("details/{listId}") { backStackEntry ->
                backStackEntry.arguments?.getString("listId")?.let { DetailsScreen(it, viewModel) }
            }
        }
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GridUnsplashTheme {
    }
}

