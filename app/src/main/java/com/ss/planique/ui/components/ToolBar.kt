package com.ss.planique.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss.planique.R
import com.ss.planique.ui.theme.Black
import com.ss.planique.ui.theme.PrimaryContainerLight
import com.ss.planique.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTopbar(scrollBehavior: TopAppBarScrollBehavior) {
    val color = MaterialTheme.colorScheme
    val isCollapsed = scrollBehavior.state.collapsedFraction > 0.5f
    MediumTopAppBar(
        navigationIcon = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painterResource(R.drawable.logo),
                    contentDescription = null,
                    Modifier.size(50.dp)
                )
                Column(modifier = Modifier.padding(start = 10.dp)) {
                    MyText(
                        txt = stringResource(id = R.string.app_name),
                        fontSize = 21.sp,
                        color = color.onPrimary,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 21.sp,
                    )
                    MyText(
                        txt = stringResource(id = R.string.app_moto),
                        fontSize = 12.sp,
                        color = color.onPrimary.copy(alpha = 0.6f),
                        fontWeight = FontWeight.Normal, lineHeight = 15.sp
                    )
                }
            }
        },
        title = {
            var text by remember { mutableStateOf("Search here...") }
            var isStartedSearching by remember { mutableStateOf(true) }
            if (!isCollapsed) {
                MyText(
                    "A quiet rain began to tap softly against the glass windowpane. Sunlight pierced through the dark clouds, casting a warm amber glow over the room. The rich aroma of fresh coffee filled the quiet house.",
                    lineHeight = 15.sp,
                    color = color.onPrimary
                )
//                OutlinedTextField(
//                    value = text,
//                    onValueChange = { newText ->
//                        if (isStartedSearching) {
//                            text = newText.removePrefix("Search here...")
//                            isStartedSearching = false
//                        } else {
//                            text = newText
//                        }
//                    },
//                    textStyle = TextStyle(
//                        fontSize = 12.sp,
//                        lineHeight = 16.sp,
//                        fontWeight = FontWeight.Normal,
//                        color = Color.Gray
//                    ),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .defaultMinSize(minHeight = 30.dp)
//                        .heightIn(
//                            min = 48.dp,
//                            max = 50.dp
//                        )
//                        .padding(end = 20.dp),
//
//                    singleLine = true,
//
//                    colors = OutlinedTextFieldDefaults.colors(
//                        focusedBorderColor = color.primary.copy(alpha = 0.5f),
//                        unfocusedBorderColor = Color.Gray,
//
//                        focusedContainerColor = Color.Transparent,
//                        unfocusedContainerColor = Color.Transparent,
//                        disabledContainerColor = Color.LightGray,
//                        errorContainerColor = Color.White,
//                    ),
//                    shape = RoundedCornerShape(20.dp)
//                )
            }
        },
        actions = {
            if (isCollapsed) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "",
                    tint = color.onPrimary,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(8.dp)
                        .clickable {}
                )
            }
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .size(30.dp)
                    .padding(8.dp)
                    .clickable {}
            )
        },
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = color.primary,
            scrolledContainerColor = color.primary,
            navigationIconContentColor = color.onPrimary,
            titleContentColor = color.onPrimary,
            actionIconContentColor = color.onPrimary
        ),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopbar(
    title: String = "Planique", isDark: Boolean,
    onModeChange: (Boolean) -> Unit
) {
    val color = MaterialTheme.colorScheme
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Column {
                    MyText(
                        title,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = color.onPrimary,
                    )
                }
            }
        },
        actions = {
            DarkLightSwitch(
                isDark = isDark,
                onModeChange = onModeChange
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = color.primary,
            navigationIconContentColor = color.onPrimary,
            titleContentColor = color.onPrimary,
            actionIconContentColor = color.onPrimary
        ),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreenTopbar(
) {
    val color = MaterialTheme.colorScheme
    TopAppBar(
        title = {
            MyText(
                txt = stringResource(id = R.string.app_name),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = color.primary,
            )
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = color.surfaceVariant,
            navigationIconContentColor = color.onPrimary,
            titleContentColor = color.onPrimary,
            actionIconContentColor = color.onPrimary
        ),
    )
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTopbar() {
    val color = MaterialTheme.colorScheme
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {
                MyText(
                    txt = stringResource(id = R.string.app_name),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = color.primary,
                    textAlign = TextAlign.Center
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            navigationIconContentColor = color.onPrimary,
            titleContentColor = color.onPrimary,
            actionIconContentColor = color.onPrimary
        ),
    )
}

@Composable
fun DarkLightSwitch(isDark: Boolean, onModeChange: (Boolean) -> Unit) {
    val thumbOffset by animateDpAsState(
        targetValue = if (isDark) 30.dp else 2.dp,
        animationSpec = tween(durationMillis = 250),
        label = "thumbOffset"
    )
    Box(
        modifier = Modifier
            .padding(end = 10.dp)
            .width(60.dp)
            .height(30.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(
                if (isDark) Black.copy(alpha = 0.6f)
                else Color.White.copy(alpha = 0.8f)
            )
            .clickable { onModeChange(!isDark) }
            .padding(2.dp)
    )
    {
        Box(
            modifier = Modifier
                .offset(x = thumbOffset)
                .size(28.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = if (isDark) Icons.Default.DarkMode
                else Icons.Default.LightMode,
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = if (isDark) Black
                else Color(0xFF374151)
            )
        }
    }
}