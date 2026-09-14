package com.ss.planique.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss.planique.data.model.Note
import com.ss.planique.ui.components.MyText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun NotesScreen() {
    val notesList = listOf(
        Note(title = "Meeting", desc = "Regarding setup the project"),
        Note(title = "Meeting", desc = "Regarding setup the project"),
        Note(title = "Meeting", desc = "Regarding setup the project"),
        Note(title = "Meeting", desc = "Regarding setup the project"),
        Note(title = "Meeting", desc = "Regarding setup the project"),
        Note(title = "Meeting", desc = "Regarding setup the project"),
        Note(title = "Meeting", desc = "Regarding setup the project"),
        Note(title = "Meeting", desc = "Regarding setup the project"),
        Note(title = "Meeting", desc = "Regarding setup the project"),
    )

    Scaffold(
    )
    { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            itemsIndexed(notesList){ index, note->
                NoteItem(note = note, index = index)
            }
        }
    }
}

@Composable
fun NoteItem(note: Note, index : Int) {
    val color = MaterialTheme.colorScheme
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp, vertical = 2.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Gray),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp).height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // +1 because index starts from 0
            MyText((index + 1).toString().padStart(2, '0'))
            VerticalDivider(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(5.dp), color = color.primary, thickness = 1.dp
            )
            Column(modifier = Modifier.padding(8.dp)) {
                MyText("Title ${note.title}", color = color.primary)
                MyText("Description ${note.desc}", fontWeight = FontWeight.Normal, fontSize = 12.sp)
            }
        }
    }
}
