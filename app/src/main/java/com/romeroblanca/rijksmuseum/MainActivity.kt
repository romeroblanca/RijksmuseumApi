package com.romeroblanca.rijksmuseum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.romeroblanca.rijksmuseum.navigation.NavigationGraph
import com.romeroblanca.rijksmuseum.presentation.theme.RijksmuseumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RijksmuseumTheme(
                dynamicColor = false
            ) {
                NavigationGraph()
            }
        }
    }
}