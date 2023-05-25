package com.dicoding.beritaku.ui.screen.berita

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.dicoding.beritaku.model.Berita
import com.dicoding.beritaku.ui.screen.detail.NewsDetail
import com.dicoding.beritaku.ui.theme.BeritakuTheme

class NewsActivity  : ComponentActivity() {
    private val berita: Berita by lazy {
        intent?.getSerializableExtra(ID) as Berita
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeritakuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NewsDetail(berita)
                }
            }
        }
    }

    companion object {
        private const val ID = "beritaId"
        fun newIntent(context: Context, berita: Berita) =
            Intent(context, NewsActivity::class.java).apply {
                putExtra(ID, berita)
            }
    }
}