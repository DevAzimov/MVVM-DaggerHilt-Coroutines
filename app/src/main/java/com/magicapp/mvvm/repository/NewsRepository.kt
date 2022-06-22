package com.magicapp.mvvm.repository

import com.magicapp.mvvm.data.local.entity.News
import com.magicapp.mvvm.data.local.entity.NewsDao
import com.magicapp.mvvm.data.remote.ApiService
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val apiService: ApiService,
    private val newsDao: NewsDao
) {

    suspend fun addNews(addNews: News) = apiService.addNews(addNews)

    suspend fun addNewsLocal(addNews: News) = newsDao.addNews(addNews)

}