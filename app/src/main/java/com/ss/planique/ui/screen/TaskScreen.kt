package com.ss.planique.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ss.planique.data.PlannerItem
import com.ss.planique.ui.components.MyText
import com.ss.planique.ui.components.ScreenTopbar

@Preview
@Composable
fun TaskScreen() {
    val color = MaterialTheme.colorScheme
    val listTask = listOf(
        PlannerItem("Wake up", "For better health want to wake up before Sunrise!", remind = true),
        PlannerItem("Go to office", "Jaan hi padega, Paisa jo chahiye", remind = true),
        PlannerItem("Read Book"),
        PlannerItem("Go to office"),
        PlannerItem("Go to office"),
    )

    Scaffold(
        containerColor = color.background,
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            LazyColumn() {
                items(listTask) { item ->
                    TaskItem(item)
                }
            }
        }
    }
}

@Composable
fun TaskItem(item: PlannerItem) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            MyText(item.title)
            item.desc?.let { desc -> MyText(item.desc) }
        }
    }
}

