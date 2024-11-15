package br.thiago.moviesjetpackcomposetmdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import br.thiago.moviesjetpackcomposetmdb.ui.navigation.MovieNavigationGraph
import br.thiago.moviesjetpackcomposetmdb.ui.theme.JetMovieTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetMovieTheme {

                App()

                }
            }
        }
    @Composable
    fun App() {
        val navController = rememberNavController()
        Scaffold(modifier = Modifier.fillMaxSize()) {
            MovieNavigationGraph(
                navController = navController,
                modifier = Modifier.padding(it)
            )
        }
    }

}


