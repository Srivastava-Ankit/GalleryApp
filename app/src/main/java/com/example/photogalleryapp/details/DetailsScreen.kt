/*

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
import androidx.navigation.NavController
import com.example.photogalleryapp.model.PictureDetails
import com.example.photogalleryapp.Utils
import com.example.photogalleryapp.model.Picture
import com.example.photogalleryapp.overview.NetworkImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState



@SuppressLint("UnrememberedMutableState", "UnusedMaterialScaffoldPaddingParameter",
    "CoroutineCreationDuringComposition"
)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun DetailsScreen(picture:Picture) {

    val items = pictureDetails
    val pagerState = rememberPagerState()
    var picture:MutableState<PictureDetails> = mutableStateOf( pictureDetails[index.toInt()])



    Utils.showLoadingDialog()
    */
/*GlobalScope.launch {
        pagerState.animateScrollToPage(page = index.toInt())
        Utils.dismissLoadingDialog()
    }*//*


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
                        url = picture[currentPage].hdurl,
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(.4f)
                    )

                    Text(text = picture[currentPage].title.trim(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 4.dp, end = 4.dp)
                    )
                    Text(text = picture[currentPage].explanation.trim(), lineHeight =20.sp,modifier = Modifier.padding(start = 4.dp, end = 4.dp))
                }
            }
        }
    }

}

*/
