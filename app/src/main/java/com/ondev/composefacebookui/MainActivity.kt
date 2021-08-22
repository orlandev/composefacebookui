package com.ondev.composefacebookui

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.ondev.composefacebookui.components.CircleButton
import com.ondev.composefacebookui.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
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
    Column(modifier = Modifier.fillMaxSize().padding(facebookContentPadding)) {
        FacebookBanner()
    }
}


@Composable
fun FacebookBanner() {
    Row(modifier = Modifier.fillMaxWidth().height(70.dp)) {
        Text(modifier = Modifier.weight(0.9f).align(Alignment.CenterVertically),
            text = "facebook",
            color = facebookLightBlue,
            style = MaterialTheme.typography.caption
        )

        Row(modifier = Modifier.fillMaxSize()
            .padding(facebookContentPadding)
            .weight(0.9f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            CircleButton(
                icon = painterResource(R.drawable.facebook_search),
                color = facebookGray,
                onClick = {}
            )

            CircleButton(
                icon = painterResource(R.drawable.facebook_notifications),
                color = facebookLightRed,
                onClick = {}
            )

            CircleButton(
                icon = painterResource(R.drawable.facebook_people),
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


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposefacebookuiTheme {
        FacebookHome()
    }
}