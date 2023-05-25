package com.dicoding.beritaku.ui.screen.berita

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dicoding.beritaku.R
import com.dicoding.beritaku.model.Berita
import com.dicoding.beritaku.model.BeritaData
import com.dicoding.beritaku.ui.theme.BeritakuTheme

@Composable
fun NewsItemView(berita: Berita, onAction: (Berita) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column(Modifier.clickable { onAction(berita) }) {
            photoUrl(berita)
            Row {
                Column(
                    modifier = Modifier.align(Alignment.Top)
                ) {
                    Text(
                        text = berita.title,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                    )

                    Text(
                        text = berita.desc,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Justify,
                        maxLines = 3
                    )
                }
            }
        }
    }
}

@Composable
private fun photoUrl(berita: Berita) {
    AsyncImage(
        model = berita.photoUrl,
        contentDescription = stringResource(R.string.img),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(corner = CornerSize(8.dp)))
    )
}

@Composable
fun NewsItemView() {
    val news = BeritaData.berita
    NewsItemView(news, onAction = {})
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun NewsItemViewPreview() {
    BeritakuTheme {
        NewsItemView()
    }
}