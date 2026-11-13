package com.example.bookshelf.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.BookshelfApplication
import com.example.bookshelf.data.Book
import com.example.bookshelf.data.BooksRepository
import kotlinx.coroutines.launch

sealed interface BooksUiState {
    data object Loading : BooksUiState
    data class Success(val books: List<Book>) : BooksUiState
    data object Error : BooksUiState
}

class BooksViewModel(private val repository: BooksRepository) : ViewModel() {

    var uiState: BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    var query: String by mutableStateOf("jazz history")
        private set

    init {
        search()
    }

    fun onQueryChange(newQuery: String) {
        query = newQuery
    }

    fun search() {
        val q = query.trim()
        if (q.isEmpty()) return
        viewModelScope.launch {
            uiState = BooksUiState.Loading
            uiState = try {
                BooksUiState.Success(repository.getBooks(q))
            } catch (e: Exception) {
                BooksUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as BookshelfApplication
                BooksViewModel(app.container.booksRepository)
            }
        }
    }
}
