package com.example.bookshelf.data

import kotlinx.serialization.Serializable

@Serializable
data class BooksResponse(val items: List<Book> = emptyList())

@Serializable
data class Book(val id: String, val volumeInfo: VolumeInfo = VolumeInfo())

@Serializable
data class VolumeInfo(
    val title: String = "",
    val imageLinks: ImageLinks? = null
)

@Serializable
data class ImageLinks(val thumbnail: String? = null) {
    /** L'API renvoie des liens http ; Android bloque le trafic non chiffré par défaut. */
    val secureThumbnail: String? get() = thumbnail?.replace("http://", "https://")
}
