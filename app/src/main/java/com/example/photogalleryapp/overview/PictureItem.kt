package com.example.photogalleryapp.overview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.example.photogalleryapp.model.Picture

@OptIn(ExperimentalCoilApi::class)
@Composable
fun PictureItem(picture: Picture) {
    Card(
        modifier = Modifier.padding(4.dp).clickable {  },
        elevation = 5.dp
    ) {
        Box {
            NetworkImage(
                url = picture.hdurl,
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(4f / 3f)
                    .size(200.dp)
            )
            Text(
                text = picture.title,
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .background(MaterialTheme.colors.primary.copy(alpha = 0.3f))
                    .padding(vertical = 4.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            )
        }
    }
}
