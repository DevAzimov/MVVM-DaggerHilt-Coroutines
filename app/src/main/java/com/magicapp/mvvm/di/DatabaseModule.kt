package com.magicapp.mvvm.di

import android.content.Context
import androidx.room.Room
import com.magicapp.mvvm.data.local.entity.NewDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun getDatabase(@ApplicationContext context: Context): NewDatabase =
        Room.databaseBuilder(context, NewDatabase::class.java, "news").build()

    @Provides
    @Singleton
    fun getNewsDao(database: NewDatabase) = database.getNewsDao()

}