package com.ss.planique

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.ss.planique.ui.navigation.MainScreen
import com.ss.planique.ui.navigation.SplashScreen
import com.ss.planique.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
//            statusBarStyle = SystemBarStyle.auto(
//                lightScrim = android.graphics.Color.TRANSPARENT,
//                darkScrim = android.graphics.Color.TRANSPARENT
//            ),
//            navigationBarStyle = SystemBarStyle.auto(
//                lightScrim = android.graphics.Color.TRANSPARENT,
//                darkScrim = android.graphics.Color.TRANSPARENT
//            )
//            statusBarStyle = SystemBarStyle.dark(
//                android.graphics.Color.TRANSPARENT // Ensures status bar icons remain white
//            )
            statusBarStyle = SystemBarStyle.auto(
                lightScrim = android.graphics.Color.TRANSPARENT,
                darkScrim = android.graphics.Color.TRANSPARENT
            )
        )
        setContent {
            AppTheme {
                PreviewScreen()
            }
        }
    }
}

@Composable
fun PreviewScreen() {
    var showSplash by remember { mutableStateOf(true) }
    if (showSplash) SplashScreen(onScreenFinish = { showSplash = false })
    else MainScreen()
}

fun shareText(activity: MainActivity) {
    val shareIntent = Intent().apply {
        action = Intent.ACTION_SEND
        addCategory(Intent.CATEGORY_DEFAULT)
        putExtra(Intent.EXTRA_TEXT, "Testing text")
        type = "text/plain"
    }
    val list = activity.packageManager.queryIntentActivities(shareIntent, PackageManager.MATCH_ALL)
    list.forEach { info ->
        Log.d("Tag", "{share text :  ${info.activityInfo.packageName}}")
    }
//    activity.startActivity(shareIntent)
    activity.startActivity(Intent.createChooser(shareIntent, "Share via"))
}
