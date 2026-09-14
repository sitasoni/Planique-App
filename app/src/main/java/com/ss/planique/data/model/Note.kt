package com.ss.planique.data.model

data class Note(
    val id : Long = 1L,
    val title : String,
    val desc : String,
    val createdAt : Long = System.currentTimeMillis(),
)