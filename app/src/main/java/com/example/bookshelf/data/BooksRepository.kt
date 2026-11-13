package com.example.bookshelf.data

import com.example.bookshelf.network.BooksApiService

interface BooksRepository {
    suspend fun getBooks(query: String): List<Book>
}

class NetworkBooksRepository(
    private val api: BooksApiService
) : BooksRepository {
    override suspend fun getBooks(query: String): List<Book> = api.search(query).items
}
