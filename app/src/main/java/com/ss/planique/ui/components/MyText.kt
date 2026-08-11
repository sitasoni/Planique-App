package com.ss.planique.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun MyText(
    txt: String,
    color: Color = Color.Black,
    fontSize: TextUnit = 15.sp,
    fontWeight: FontWeight = FontWeight.SemiBold,
    lineHeight : TextUnit = TextUnit.Unspecified
) {
    Text(txt, color = color, fontSize = fontSize, fontWeight = fontWeight, lineHeight = lineHeight)
}