package com.ss.planique.data

import androidx.compose.ui.graphics.vector.ImageVector
import java.util.Date

data class ScreenItem(val title: String, val desc: String? = null, val img: ImageVector)

data class PlannerItem(
    val title: String,
    val desc : String? = null,
    val remind : Boolean = false,
    val dateTime : Date? = null
)