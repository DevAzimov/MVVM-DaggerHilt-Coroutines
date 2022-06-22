package com.magicapp.mvvm.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class News(
    @PrimaryKey(autoGenerate = true)
    val  id: Int,
    val title: String,
    val image: String,
    val description: String
)