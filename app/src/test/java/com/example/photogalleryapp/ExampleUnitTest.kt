package com.example.photogalleryapp

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.photogalleryapp.model.Picture
import com.example.photogalleryapp.model.PictureDetails
import com.example.photogalleryapp.network.NasaApi
import com.example.photogalleryapp.network.NasaRepository
import com.example.photogalleryapp.network.NasaRepositoryImpl
import com.example.photogalleryapp.unittest.TestUtils
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    suspend fun isPictureListNotNull() {
        assertNotNull(TestUtils.getPictureFromNetwork())
    }

    @Test
    suspend fun isPictureListEmpty() {
        assertEquals(0, TestUtils.getPictureFromNetwork().size)
    }

    @Test
    suspend fun isPictureListFetched() {
       assertEquals(26, TestUtils.getPictureFromNetwork().size)
     }

    @Test
    @Composable
    fun isNetworkErrorOccurred() {
        assertEquals("Network issue or Server is down", TestUtils.getNetworkError())
    }

    @Test
    @Composable
    fun isServerDown() {
        assertEquals("Failed to connect to server \uD83D\uDE22", TestUtils.getNetworkError())
    }


}