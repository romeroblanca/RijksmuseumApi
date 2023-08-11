package com.romeroblanca.rijksmuseum.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.romeroblanca.rijksmuseum.presentation.collection.ArtCollectionScreen
import com.romeroblanca.rijksmuseum.presentation.details.ArtObjectDetailsScreen

fun NavGraphBuilder.addArtCollectionScreen(navController: NavHostController) {
    composable(Screen.ArtCollectionScreen.route) {
        ArtCollectionScreen { artObjectId ->
            navController.navigate("${Screen.ArtObjectDetailsScreen.route}/$artObjectId")
        }
    }
}

fun NavGraphBuilder.addArtObjectDetailsScreen(navController: NavHostController) {
    composable(
        route = Screen.ArtObjectDetailsScreen.route + "/{artObjectId}",
        arguments = Screen.ArtObjectDetailsScreen.arguments
    ) { navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getString("artObjectId") ?: ""
        ArtObjectDetailsScreen(id = id) {
            navController.popBackStack()
        }
    }
}