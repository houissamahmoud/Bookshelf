package com.example.bookshelf.network

import com.example.bookshelf.data.BooksResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApiService {
    @GET("volumes")
    suspend fun search(
        @Query("q") query: String,
        @Query("key") key: String = "AIzaSyBe3WCxFnSa0VFiJ2ikNXY4qFpdTNJ5Smk"
    ): BooksResponse
}