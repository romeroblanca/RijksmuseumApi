package com.romeroblanca.rijksmuseum.presentation.details

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.romeroblanca.rijksmuseum.R
import com.romeroblanca.rijksmuseum.domain.model.artobjectdetailsmodel.ArtObjectDetailsModel
import kotlinx.coroutines.job

val requester = FocusRequester()

@Composable
fun ShowArtObjectDetails(
    artObjectDetails: ArtObjectDetailsModel
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .focusRequester(focusRequester = requester)
                .focusable(),
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            error = painterResource(id = R.drawable.ic_launcher_background),
            model = ImageRequest.Builder(LocalContext.current)
                .data(artObjectDetails.artObject.webImage.url)
                .build(),
            contentDescription = "Personaje ${ artObjectDetails.artObject.label.title } Imagen"
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = artObjectDetails.artObject.label.description,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = artObjectDetails.artObject.label.makerLine,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }

    /*
    Ejecuta el requestFocus al finalizar la composición de la vista
     */
    LaunchedEffect(Unit) {
        this.coroutineContext.job.invokeOnCompletion {
            requester.requestFocus()
        }
    }
}

@Composable
fun AndroidViewTest(artObjectDetails: ArtObjectDetailsModel) {
    var starred by remember {
        mutableStateOf(false)
    }

}

/*
@Composable
@Preview
fun ShowHeroPreview() {
    ShowArtObjectDetails(
        HeroTestDataBuilder()
            .withName("Sample name long text long text long text long textlong text long text long text")
            .withDescription("")

            .buildSingle()
    )
}
*/