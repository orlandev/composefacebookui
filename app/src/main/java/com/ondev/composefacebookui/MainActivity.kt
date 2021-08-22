package com.ondev.composefacebookui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ondev.composefacebookui.components.CircleButton
import com.ondev.composefacebookui.components.FacebookBanner
import com.ondev.composefacebookui.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposefacebookuiTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    FacebookHome()
                }
            }
        }
    }
}

val facebookContentPadding = 16.dp

@Composable
fun FacebookHome() {
    Column(modifier = Modifier.fillMaxSize()
        .padding(facebookContentPadding)) {
        FacebookBanner()
        FacebookPerfilShareThink()
        FacebookShareClips()
        FacebookPeopleKnow()
    }
}

@Composable
fun FacebookPeopleKnow() {
    Spacer(modifier = Modifier.height(10.dp))
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().background(Color.Red)
            .height(200.dp)
    ) {
        items(10) {
            FacebookPeoplePerfil("Lisa", R.drawable.facebook_perfil, R.drawable.facebook_perfil)
        }
    }
}

@Composable
fun FacebookPeoplePerfil(name: String, avatar: Int, history: Int) {
    val imageHistoryRoundPercent = RoundedCornerShape(30)
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxHeight().width(140.dp).padding(facebookContentPadding)) {
        Box(contentAlignment = Alignment.Center) {
            Image(painter = painterResource(history),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
                    .padding(bottom = facebookContentPadding)
                    .clip(imageHistoryRoundPercent)
                    .border(0.dp, color = Color.White, shape = imageHistoryRoundPercent),
                contentDescription = null
            )
            Image(painter = painterResource(avatar),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.BottomCenter)
                    .clip(CircleShape)
                    .border(3.dp, Color.White, CircleShape),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = name)
    }
}


@Composable
fun FacebookShareClips() {
    Spacer(modifier = Modifier.height(10.dp))
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .height(50.dp)
    )
    {
        item {
            FacebookClipButton(
                modifier = Modifier.clickable { },
                text = "Gallery",
                icon = painterResource(R.drawable.facebook_gallery),
                textColor = facebookLightGreen,
                backgroundColor = facebookLightGreenAplha,
                buttonColor = facebookDarkGreen
            )
            Spacer(modifier = Modifier.width(facebookContentPadding))
        }
        item {
            FacebookClipButton(
                modifier = Modifier.clickable { },
                text = "Tag friends",
                icon = painterResource(R.drawable.facebook_people),
                textColor = facebookDarkBlue,
                backgroundColor = facebookBlue500,
                buttonColor = facebookLightBlue
            )
            Spacer(modifier = Modifier.width(facebookContentPadding))
        }
        item {
            FacebookClipButton(
                modifier = Modifier.clickable { },
                text = "Live",
                icon = painterResource(R.drawable.facebook_camera),
                textColor = facebookPink,
                backgroundColor = facebookLightPink,
                buttonColor = facebookPink
            )
            Spacer(modifier = Modifier.width(facebookContentPadding))
        }
        item {
            FacebookClipButton(
                modifier = Modifier.clickable { },
                text = "Settings",
                icon = painterResource(R.drawable.facebook_settings),
                textColor = facebookGray,
                backgroundColor = facebookLightGray,
                buttonColor = facebookGray
            )
            Spacer(modifier = Modifier.width(facebookContentPadding))
        }
    }
}

@Composable
fun FacebookClipButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: Painter,
    textColor: Color,
    buttonColor: Color,
    backgroundColor: Color,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clip(CircleShape)
            .wrapContentWidth(align = Alignment.Start)
            .background(backgroundColor)
    ) {
        CircleButton(
            icon = icon,
            color = buttonColor,
            onClick = {}
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text,
            color = textColor,
            modifier = Modifier.align(Alignment.CenterVertically).padding(end = 8.dp))
    }
}

@Composable
fun FacebookPerfilShareThink() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painterResource(R.drawable.facebook_perfil),
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(60.dp)
                .weight(0.2f)
                .clip(CircleShape)
                .background(color = Color.White),
            contentDescription = "Lisa")
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = stringResource(R.string.text_hint_user_think),
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.body1,
            color = facebookGray
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposefacebookuiTheme {
        FacebookHome()
    }
}