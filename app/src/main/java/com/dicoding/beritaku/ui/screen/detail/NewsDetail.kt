package com.dicoding.beritaku.ui.screen.detail

import android.app.Activity
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dicoding.beritaku.R
import com.dicoding.beritaku.model.Berita
import com.dicoding.beritaku.model.BeritaData
import com.dicoding.beritaku.ui.theme.BeritakuTheme

@Composable
fun NewsDetail(berita: Berita) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Column {
            TopBar()
            BoxWithConstraints(modifier = Modifier.weight(1f)) {
                Box {
                    Surface {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .verticalScroll(scrollState),
                        ) {
                            Header(
                                scrollState,
                                berita,
                                this@BoxWithConstraints.maxHeight
                            )
                            Content(berita, this@BoxWithConstraints.maxHeight)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TopBar() {
    Column {
        TopAppBar(
            title = { Text(text = stringResource(R.string.detail)) },
            navigationIcon = {
                val context = LocalContext.current as? Activity
                Image(
                    painter = painterResource(R.drawable.ic_baseline_arrow_back_24),
                    contentDescription = stringResource(R.string.back),
                    modifier = Modifier
                        .clickable { context?.finish() }
                        .padding(start = 10.dp)
                        .size(30.dp)
                )
            }
        )
    }
}

@Composable
private fun Header(
    scrollState: ScrollState,
    berita: Berita,
    containerHeight: Dp
) {
    val offset = (scrollState.value / 2)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }

    Spacer(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .padding(top = offsetDp)
    )

    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp),
        model = berita.photoUrl,
        contentScale = ContentScale.Crop,
        contentDescription = berita.title
    )
}

@Composable
private fun Content(berita: Berita, containerHeight: Dp) {
    Column {
        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
        ) {
            Text(
                text = berita.title,
                modifier = Modifier,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = berita.author,
                style = MaterialTheme.typography.body1
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .padding(8.dp)
        ) {
            Text(
                text = berita.date,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Normal
            )
        }

        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = berita.desc,
                modifier = Modifier,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Justify
            )
        }

        Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
fun Detail() {
    val news = BeritaData.berita
    NewsDetail(news)
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DetailPreview() {
    BeritakuTheme {
        Detail()
    }
}