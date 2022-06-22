package com.magicapp.mvvm.data.local.entity

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [News::class], version = 1)
abstract class NewDatabase: RoomDatabase() {

    abstract fun getNewsDao(): NewsDao

}