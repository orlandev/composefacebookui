package com.ondev.composefacebookui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.ondev.composefacebookui.components.CircleButton
import com.ondev.composefacebookui.ui.theme.*
import kotlin.random.Random

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

data class Person(
    val id: Int, val name: String, val avatar: Int, val history: Int,
)

//FakeData
val persons = listOf<Person>(
    Person(0, "Raquel Leyva", R.drawable.perfil1, R.drawable.perfil_history1),
    Person(1, "Raul Estrada", R.drawable.perfil2, R.drawable.perfil_history2),
    Person(2, "Lisa Acosta", R.drawable.perfil3, R.drawable.perfil_history3),
    Person(3, "Ester Quintana", R.drawable.perfil4, R.drawable.perfil_history4),
    Person(4, "Juan Rodriguez", R.drawable.perfil5, R.drawable.perfil_history5),
    Person(5, "Milena Leyva", R.drawable.perfil6, R.drawable.perfil_history6),
    Person(6, "Juana Reyes", R.drawable.perfil7, R.drawable.perfil_history7),
)

data class Post(
    val idOwner: Int,
    val textPosted: String,
    val time: String,
    val comments: Int,
    val shares: Int,
)


val facebookContentPadding = 16.dp
val facebookDividerPadding = 8.dp

@Composable
fun FacebookHome() {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            FacebookBanner()
        }
        item {
            FacebookPerfilShareThink()
        }
        item {
            FacebookShareClips()
        }
        item {
            FacebookPeopleKnow(persons)
        }
        item {
            FacebookDivider()
        }

        items(FakePostRepository.getPosts(persons.size)) { post ->
            ItemPost(post)
            FacebookDivider()
        }

    }
}

@Composable
fun ItemPost(post: Post) {
    Column(modifier = Modifier.fillMaxWidth().height(400.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().height(70.dp).padding(facebookContentPadding)) {
            Image(
                rememberImagePainter(persons[post.idOwner].avatar),
                contentDescription = persons[post.idOwner].name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = persons[post.idOwner].name)
            Text(text = post.time, modifier = Modifier.weight(1f),
                textAlign = TextAlign.Companion.End)
        }
        Image(rememberImagePainter(persons[post.idOwner].history),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth())

        Text(text = post.textPosted,
            modifier = Modifier.fillMaxWidth().padding(facebookContentPadding),
            style = MaterialTheme.typography.subtitle2)

        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().height(50.dp)
                .padding(start = facebookContentPadding, end = facebookContentPadding)) {
            IconButton(onClick = { },
                modifier = Modifier.size(30.dp)
                    .padding(4.dp).weight(0.1f)
            ) {
                Icon(painterResource(R.drawable.facebook_like),
                    contentDescription = null,
                    tint = facebookDarkBlue)
            }
            IconButton(onClick = { },
                modifier = Modifier.size(30.dp)
                    .padding(4.dp).weight(0.1f)
            ) {
                Icon(Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    tint = facebookLightRed)
            }

            Text(text = "${post.comments} Comments",
                modifier = Modifier.weight(0.5f),
                textAlign = TextAlign.End)
            Text(text = "${post.shares} Shares",
                modifier = Modifier.weight(0.3f),
                textAlign = TextAlign.End)
        }

    }
}


@Composable
fun FacebookBanner() {
    Row(modifier = Modifier.fillMaxWidth().height(70.dp)
        .padding(start = facebookContentPadding, end = facebookContentPadding)) {
        Text(modifier = Modifier.weight(0.9f).align(Alignment.CenterVertically),
            text = "facebook",
            color = facebookSemiDarkBlue,
            style = MaterialTheme.typography.caption
        )

        Row(modifier = Modifier.fillMaxSize()
            .padding(facebookContentPadding)
            .weight(0.9f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            CircleButton(
                icon = painterResource(com.ondev.composefacebookui.R.drawable.facebook_search),
                color = facebookGray,
                onClick = {}
            )

            CircleButton(
                icon = painterResource(com.ondev.composefacebookui.R.drawable.facebook_notifications),
                color = facebookLightRed,
                onClick = {}
            )

            CircleButton(
                icon = painterResource(com.ondev.composefacebookui.R.drawable.facebook_people),
                color = facebookLightBlue,
                onClick = {}
            )

            CircleButton(icon = painterResource(R.drawable.facebook_messenger),
                color = facebookSemiDarkBlue,
                contentPadding = 8.dp,
                onClick = {})
        }
        Spacer(modifier = Modifier.height(10.dp))

    }
}

@Composable
fun FacebookPeopleKnow(persons: List<Person>) {
    Spacer(modifier = Modifier.height(10.dp))
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .height(200.dp).padding(2.dp)
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
    val imageHistoryRoundPercent = RoundedCornerShape(20)
    Box(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight()
                .width(130.dp)
                .padding(8.dp)) {
            Box(contentAlignment = Alignment.Center) {
                Image(painter = rememberImagePainter(history),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                        .padding(bottom = 30.dp)
                        .clip(imageHistoryRoundPercent)
                        .border(0.dp, color = Color.White, shape = imageHistoryRoundPercent),
                    contentDescription = null
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.BottomCenter)) {
                    Image(painter = rememberImagePainter(avatar),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .border(3.dp, Color.White, CircleShape),
                        contentDescription = null
                    )
                    Text(text = name,
                        style = MaterialTheme.typography.subtitle1,
                        color = facebookDarkGray,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

    }
}


@Composable
fun FacebookShareClips() {
    Spacer(modifier = Modifier.height(10.dp))
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .height(50.dp)
            .padding(start = facebookContentPadding)
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
    Row(modifier = Modifier.padding(start = facebookContentPadding, end = facebookContentPadding),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically)
    {
        val currentUser = persons[Random.nextInt(persons.size - 1)]
        Image(rememberImagePainter(currentUser.avatar),
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(60.dp)
                .weight(0.2f)
                .clip(CircleShape)
                .background(color = Color.White),
            contentDescription = "Lisa")
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "${stringResource(R.string.text_hint_user_think)}, ${currentUser.name}?",
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

@Composable
fun FacebookDivider() {
    Divider(modifier = Modifier.fillMaxWidth().height(facebookDividerPadding))
}