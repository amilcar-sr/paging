package com.codesgood.paging.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.codesgood.paging.model.Movie
import com.codesgood.paging.network.sourcefactory.MovieSourceFactory

class MovieViewModel : ViewModel() {
    private lateinit var movies: LiveData<PagedList<Movie>>

    fun getPopularMovies(): LiveData<PagedList<Movie>> {
        if (!this::movies.isInitialized) {
            val pagedListConfig = PagedList.Config.Builder()
                .setPageSize(20)
                .setPrefetchDistance(60)
                .setEnablePlaceholders(true)
                .build()

            movies = LivePagedListBuilder(MovieSourceFactory(), pagedListConfig).build()
        }

        return movies
    }
}