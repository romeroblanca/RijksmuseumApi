package com.romeroblanca.rijksmuseum.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
) {
    object ArtCollectionScreen : Screen(
        route = "artCollection",
        arguments = emptyList()
    )

    object ArtObjectDetailsScreen : Screen(
        route = "artObjectDetails",
        arguments = listOf(
            navArgument("artObjectId") {
                type = NavType.StringType
                nullable = false
            }
        )
    )
}