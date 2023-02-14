package com.example.photogalleryapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.photogalleryapp.details.DetailsScreen
import com.example.photogalleryapp.overview.GridScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeActivity : ComponentActivity() {
   val TAG: String? = "HomeActivity"
    var pictureViewModel: PictureViewModel? = null
    private var pictureDetailsList: List<PictureDetails>? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(pictureDetailsList == null) {
            Utils.showLoadingDialog(this)
            GlobalScope.launch(Dispatchers.IO) {
                pictureViewModel = PictureViewModel()
                pictureDetailsList = pictureViewModel!!.getAllPictureList()!!
                withContext(Dispatchers.Main) {
                    setContent {
                        LazyVerticalGridActivityScreen(pictureDetailsList!!)
                        Utils.dismissLoadingDialog()
                    }

                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyVerticalGridActivityScreen(pictureDetailsList:List<PictureDetails>) {
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

    Scaffold(
        content = {
            NavHost(navController = navController, startDestination = "home") {
                composable("home") { GridScreen(navController, pictureDetailsList) }
                composable("details/{listId}") { backStackEntry ->
                    backStackEntry.arguments?.getString("listId")?.let { DetailsScreen(it, navController, navigationIcon, pictureDetailsList) }

                }
            }
        }
    )
}

