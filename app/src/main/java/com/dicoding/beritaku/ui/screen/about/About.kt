package com.dicoding.beritaku.ui.screen.about

import android.annotation.SuppressLint
import android.app.Activity
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dicoding.beritaku.R
import com.dicoding.beritaku.ui.theme.BeritakuTheme

class About : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            rememberScrollState()
            BeritakuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            TopBar()
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Box(contentAlignment = Alignment.Center) { ProfilePicture() }

                                Column(modifier = Modifier.padding(top = 8.dp)) {
                                    Text(
                                        text = stringResource(R.string.username),
                                        style = MaterialTheme.typography.h5,
                                        textAlign = TextAlign.Center
                                    )
                                }

                                Column(modifier = Modifier.padding(top = 8.dp)) {
                                    Text(
                                        text = stringResource(R.string.name),
                                        modifier = Modifier,
                                        style = MaterialTheme.typography.h6,
                                        textAlign = TextAlign.Center
                                    )
                                }

                                Column(modifier = Modifier.padding(top = 8.dp)) {
                                    Text(
                                        text = stringResource(R.string.email),
                                        modifier = Modifier,
                                        style = MaterialTheme.typography.body1,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ProfilePicture(){
    AsyncImage(
        modifier = Modifier
            .size(200.dp)
            .padding(top = 20.dp)
            .clip(RoundedCornerShape(corner = CornerSize(100.dp))),
        model = stringResource(R.string.photoUrl),
        contentScale = ContentScale.Crop,
        contentDescription = stringResource(R.string.img)
    )
}

@Composable
fun TopBar() {
    Column {
        TopAppBar(
            title = { Text(text = stringResource(R.string.about)) },
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

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TopBarPreview() {
    BeritakuTheme {
        TopBar()
    }
}