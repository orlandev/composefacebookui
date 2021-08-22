package com.ondev.composefacebookui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ondev.composefacebookui.R
import com.ondev.composefacebookui.facebookContentPadding
import com.ondev.composefacebookui.ui.theme.*

@Composable
fun FacebookBanner() {
    Row(modifier = Modifier.fillMaxWidth().height(70.dp)) {
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

