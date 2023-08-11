package com.romeroblanca.rijksmuseum.presentation.collection

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.viewinterop.AndroidView
import com.romeroblanca.rijksmuseum.components.ShowError
import com.romeroblanca.rijksmuseum.presentation.details.ShowArtObjectDetails
import com.romeroblanca.rijksmuseum.presentation.theme.globalPadding
import com.romeroblanca.rijksmuseum.components.LogoComponent
import org.koin.androidx.compose.koinViewModel
import androidx.compose.ui.viewinterop.AndroidView


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ArtCollectionScreen(
    artCollectionViewModel: ArtCollectionViewModel = koinViewModel(),
    onItemClick: (String) -> Unit
) {
    val state = artCollectionViewModel.artCollection.observeAsState()
    val errorState = artCollectionViewModel.errorMessage.observeAsState()

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }



    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {



                        AndroidView(
                            modifier = Modifier
                                .semantics {
                                    contentDescription = "Hacer Favorito"
                                },
                            factory = { context ->
                                LogoComponent(context)
                            },
                        )
                    }
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(
                vertical = globalPadding
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val artCollection = state.value
            items(artCollection?.artObjects?.size ?: 0) { i ->
                // Unwrap
                val item = artCollection?.artObjects?.get(i)
                item?.let { artObject ->
                    ShowArtCollection(artObject) {
                        onItemClick.invoke(artObject.objectNumber)
                    }
                }

            }
        }
    }
}