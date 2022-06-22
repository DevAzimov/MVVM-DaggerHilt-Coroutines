package com.magicapp.mvvm.data.local.entity

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface NewsDao {

    @Insert
    suspend fun addNews(news: News)
}