package com.romeroblanca.rijksmuseum.presentation.details

import android.annotation.SuppressLint
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.romeroblanca.rijksmuseum.components.ShowError
import com.romeroblanca.rijksmuseum.presentation.theme.Black
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ArtObjectDetailsScreen(
    id: String = "",
    artObjectDetailsViewModel: ArtObjectDetailsViewModel = koinViewModel(),
    onBack: () -> Unit
) {
    val artObjectDetailsState = artObjectDetailsViewModel.artObjectDetails.observeAsState()
    val errorState = artObjectDetailsViewModel.errorMessage.observeAsState()

    artObjectDetailsViewModel.getArtObjectDetails(id)

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    val result = artObjectDetailsState.value

    result?.let { artObjectDetails ->
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("${ artObjectDetails.artObject.label.title }")
                    },
                    navigationIcon = {
                        IconButton(
                            modifier = Modifier.semantics {
                                contentDescription = "Go back"
                            },
                            onClick = onBack
                        ) {
                            Icon(Icons.Filled.ArrowBack, null)
                        }
                    }
                )
            }
        ) {
            ShowArtObjectDetails(artObjectDetails = artObjectDetails)
        }
    } ?: run {
        ShowError("Unknown error")
    }
}