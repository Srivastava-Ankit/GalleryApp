

package com.example.photogalleryapp.details

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ShareCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.photogalleryapp.PictureViewModel
import com.example.photogalleryapp.model.PictureDetails
import com.example.photogalleryapp.Utils
import com.example.photogalleryapp.model.Picture
import com.example.photogalleryapp.overview.NetworkImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@SuppressLint("UnrememberedMutableState", "UnusedMaterialScaffoldPaddingParameter",
    "CoroutineCreationDuringComposition"
)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun DetailsScreen(index:String, viewModel: PictureViewModel) {

    val state = viewModel.state.value
    val items = state.images
    val pagerState = rememberPagerState()
    val globalCoroutine = rememberCoroutineScope()

    Utils.showLoadingDialog()
    globalCoroutine.launch {
        pagerState.animateScrollToPage(page = index.toInt())
        Utils.dismissLoadingDialog()
    }


    Scaffold{
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            HorizontalPager(
                count = items.size,
                state = pagerState,
            ) { currentPage ->
                Column {
                    NetworkImage(
                        url = items[currentPage].hdurl,
                        contentDescription = null,
                        modifier = Modifier.
                                 fillMaxWidth()
                                 .height(300.dp)
                    )
                    Text(text = items[currentPage].title.trim(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 4.dp, start = 14.dp, end = 8.dp)
                    )
                    Text(text = items[currentPage].explanation.trim(),fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp, start = 14.dp, end = 10.dp))
                }
            }
        }
    }

}


