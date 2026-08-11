package com.ss.planique

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ss.planique.ui.theme.PlaniqueTheme2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            PlaniqueTheme
            PlaniqueTheme2 {
//                HomeScreen()
                NotesScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Gray),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = "Welcome",
           modifier = Modifier.padding(13.dp),
            color = Color.White
        )
    }
}

