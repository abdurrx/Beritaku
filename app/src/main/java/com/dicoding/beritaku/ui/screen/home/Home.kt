package com.dicoding.beritaku.ui.screen.home

import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.beritaku.R
import com.dicoding.beritaku.model.Berita
import com.dicoding.beritaku.model.BeritaData
import com.dicoding.beritaku.ui.screen.about.About
import com.dicoding.beritaku.ui.screen.berita.NewsItemView
import com.dicoding.beritaku.ui.theme.BeritakuTheme

@Composable
fun Home(onAction: (Berita) -> Unit) {
    val news = remember { BeritaData.beritaList }
    Column {
        TopBar()
        Box(Modifier.fillMaxSize()) {
            Box(
                Modifier.align(Alignment.BottomCenter)
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    items(
                        items = news,
                        itemContent = {
                            NewsItemView(it, onAction)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun TopBar() {
    Column {
        TopAppBar(
            title = { Text(text = stringResource(R.string.news)) },
            actions = {
                val context = LocalContext.current
                Image(
                    painter = painterResource(R.drawable.ic_baseline_account_circle_24),
                    contentDescription = stringResource(R.string.about),
                    modifier = Modifier
                        .clickable {
                            context.startActivity(
                                Intent(
                                    context,
                                    About::class.java
                                )
                            )
                        }
                        .padding(end = 10.dp)
                        .size(30.dp)
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TopBarPreview() {
    BeritakuTheme {
        TopBar()
    }
}