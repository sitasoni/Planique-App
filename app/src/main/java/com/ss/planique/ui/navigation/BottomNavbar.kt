package com.ss.planique.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Countertops
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person2
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

sealed class NavItem(var route: String, val title: String, val icon: ImageVector) {
    object Home : NavItem("home", "Home", Icons.Default.Home)
    object TaskFlow : NavItem("task", "TaskFlow", Icons.Default.Countertops)
    object Counter : NavItem("counter", "Counter", Icons.Default.Countertops)
    object Profile : NavItem("profile", "Profile", Icons.Default.Person2)
}

@Composable
fun AppBottomBar(currentRoute: String, onNavigate: (String) -> Unit) {
    val color = MaterialTheme.colorScheme
    val items = listOf(NavItem.Home, NavItem.TaskFlow, NavItem.Counter, NavItem.Profile)

    NavigationBar(
        modifier = Modifier.shadow(elevation = 8.dp), // Adds a subtle drop shadow
        containerColor = color.surface,
//        containerColor = Color.Transparent,
        contentColor = color.onSurface
    ) {
        items.forEach { item ->
            val isSelected = currentRoute == item.route

            NavigationBarItem(
                selected = isSelected,
                onClick = {onNavigate(item.route)},
                icon = {Icon(imageVector =item.icon, contentDescription = item.title)},
                label = { Text(text = item.title) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = color.onPrimaryContainer,
                    selectedTextColor = color.primary,
                    indicatorColor = color.primaryContainer,
                    unselectedIconColor = color.onSurfaceVariant,
                    unselectedTextColor = color.onSurfaceVariant
                )
            )
        }
    }
}