package com.ondev.composefacebookui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircleButton(
    icon: Painter,
    color: Color,
    buttonSize: Dp = 30.dp,
    contentPadding: Dp = 4.dp,
    onClick: () -> Unit,
) {
    IconButton(onClick = onClick,
        modifier = Modifier.size(buttonSize)
            .background(color, shape = CircleShape)
            .padding(contentPadding)
    ) {
        Icon(icon, contentDescription = null, tint = Color.White)
    }
}