package com.ondev.composefacebookui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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

//FakeData
val persons = listOf<Person>(
    Person("Raquel Leyva", R.drawable.perfil1, R.drawable.perfil_history1),
    Person("Raul Estrada", R.drawable.perfil2, R.drawable.perfil_history2),
    Person("Lisa Acosta", R.drawable.perfil3, R.drawable.perfil_history3),
    Person("Ester Quintana", R.drawable.perfil4, R.drawable.perfil_history4),
    Person("Juan Rodriguez", R.drawable.perfil5, R.drawable.perfil_history5),
    Person("Milena Leyva", R.drawable.perfil6, R.drawable.perfil_history6),
    Person("Juana Reyes", R.drawable.perfil7, R.drawable.perfil_history7),
)

val facebookContentPadding = 16.dp

@Composable
fun FacebookHome() {
    Column(modifier = Modifier.fillMaxSize()
        .padding(facebookContentPadding)) {
        FacebookBanner()
        FacebookPerfilShareThink()
        FacebookShareClips()
        FacebookPeopleKnow(persons)
    }
}

data class Person(
    val name: String, val avatar: Int, val history: Int,
)

@Composable
fun FacebookPeopleKnow(persons: List<Person>) {
    Spacer(modifier = Modifier.height(10.dp))
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .height(200.dp)
    ) {
        items(persons) { currentPerson ->
            FacebookPeoplePerfil(currentPerson.name,
                currentPerson.avatar,
                currentPerson.history
            )
        }
    }
}

@Composable
fun FacebookPeoplePerfil(name: String, avatar: Int, history: Int) {
    val imageHistoryRoundPercent = RoundedCornerShape(30)
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxHeight()
            .width(140.dp)
            .padding(8.dp)) {
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
        Text(text = name, style = MaterialTheme.typography.subtitle1)
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