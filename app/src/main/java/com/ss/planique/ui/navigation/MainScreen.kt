package com.ss.planique.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.ss.planique.ui.screen.HomeScreen
import com.ss.planique.ui.screen.ProfileScreen
import com.ss.planique.ui.screen.TaskScreen
import com.ss.planique.ui.screen.counter.CounterScreen
import com.ss.planique.ui.theme.AppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun MainScreen() {
    var currentRoute by remember { mutableStateOf(NavItem.Home.route) }

    AppTheme() {
        Scaffold(
            bottomBar = {
                AppBottomBar(
                    currentRoute,
                    onNavigate = { route -> currentRoute = route })
            }
        ) {
            Box {
                when (currentRoute) {
                    NavItem.Home.route -> HomeScreen()
                    NavItem.TaskFlow.route -> TaskScreen()
                    NavItem.Counter.route -> CounterScreen()
                    NavItem.Profile.route -> ProfileScreen()
                }
            }
        }
    }
}