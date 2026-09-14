package com.ss.planique.ui.screen.counter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss.planique.ui.components.MyText

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CounterScreen() {
    val color = MaterialTheme.colorScheme
    val counterList = listOf("Water", "Step", "Exercise")
    var showCounter by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = color.background,
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { showCounter = true },
                containerColor = color.primaryContainer,
                contentColor = color.onPrimaryContainer,
                shape = RoundedCornerShape(20.dp),
                text = {
                    MyText(
                        "New Counter",
                        color = color.onPrimaryContainer,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = color.onPrimaryContainer
                    )
                }
            )
            if (showCounter) {
                AddNewCounter(onDismiss = {})
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            items(counterList) { name ->
                CounterItem(name)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewCounter(onDismiss: () -> Unit) {
    val color = MaterialTheme.colorScheme
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = color.surfaceContainerHigh,
        contentColor = color.onSurface
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            MyText(
                "Title of the Item",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = color.onSurface
            )
            MyText("Description of the Item", fontSize = 14.sp, color = color.onSurfaceVariant)
            MyText("Starting Value", fontSize = 14.sp, color = color.onSurfaceVariant)
            MyText("Target Value", fontSize = 14.sp, color = color.onSurfaceVariant)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun CounterItem(title: String) {
    val color = MaterialTheme.colorScheme
    var count by remember { mutableIntStateOf(7) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = color.surfaceContainer,
            contentColor = color.onSurface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MyText(
                title, fontSize = 18.sp, color = color.onSurface, fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f),
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                IconButton(
                    onClick = { if (count > 0) count-- },
                    modifier = Modifier
                        .size(25.dp)
                        .background(color.primaryContainer, CircleShape)
                ) {
                    Text(
                        text = "-",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = color.onPrimaryContainer
                    )
                }
                MyText(
                    txt = count.toString(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = color.onSurface
                )
                IconButton(
                    onClick = { count++ },
                    modifier = Modifier
                        .size(25.dp)
                        .background(color.primary, CircleShape)
                ) {
                    Text(
                        text = "+",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = color.onPrimary
                    )
                }
            }
        }
    }
}

@Composable
fun CounterItemCard(
    title: String,
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onDecrement) {
                    Text("-", style = MaterialTheme.typography.titleLarge)
                }
                Text(
                    text = count.toString(),
                    modifier = Modifier.padding(horizontal = 12.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
                IconButton(onClick = onIncrement) {
                    Text("+", style = MaterialTheme.typography.titleLarge)
                }
            }
        }
    }
}