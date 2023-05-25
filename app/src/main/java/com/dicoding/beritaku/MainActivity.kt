package com.dicoding.beritaku

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dicoding.beritaku.model.Berita
import com.dicoding.beritaku.ui.screen.berita.NewsActivity
import com.dicoding.beritaku.ui.screen.home.Home
import com.dicoding.beritaku.ui.theme.BeritakuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeritakuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp {
                        startActivity(NewsActivity.newIntent(this, it))
                    }
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyApp(onAction: (Berita) -> Unit) {
    Scaffold(
        content = {
            Home(onAction)
        }
    )
}