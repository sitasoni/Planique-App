package com.ss.planique.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss.planique.R
import com.ss.planique.ui.theme.main
import com.ss.planique.ui.theme.orange6
import com.ss.planique.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediumToolbar(scrollBehavior: TopAppBarScrollBehavior) {
    MediumTopAppBar(
        title = {
            Column() {
                MyText(
                    "Planique",
                    fontSize = 18.sp,
                    color = main,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 21.sp
                )
                MyText(
                    "Panning of Unique",
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Normal, lineHeight = 15.sp
                )
            }
        },
        navigationIcon = {
            Image(
                painterResource(id = R.drawable.planq_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .size(45.dp)
                    .padding(8.dp)
                    .clickable {}
            )
        },
        scrollBehavior = scrollBehavior,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
            ) {
                Image(
                    painterResource(id = R.drawable.planq_logo),
                    modifier = Modifier
                        .size(60.dp)
//                        .padding(10.dp)
                        .clip(RectangleShape),
                    contentDescription = null
                )
                Column() {
                    MyText("Planique", fontSize = 18.sp, color = main,  lineHeight = 12.sp)
                    MyText(
                        "Planning of Unique",
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = white, lineHeight = 12.sp
                    )
                }
            }
        }
    )
}