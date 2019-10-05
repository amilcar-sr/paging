package com.codesgood.paging.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.codesgood.paging.model.Movie
import com.codesgood.paging.network.sourcefactory.MovieSourceFactory

class MovieViewModel : ViewModel() {

    //We hold this LiveData to make sure we use the same MovieSource instead of creating new ones unnecessarily
    private lateinit var movies: LiveData<PagedList<Movie>>

    /**
     * Returns a instance of LiveData<PagedList<Movie>> that is attached to our MovieSource, that way we get
     * the new page of movies when needed
     */
    fun getPopularMovies(): LiveData<PagedList<Movie>> {
        if (!this::movies.isInitialized) {
            //This defines the way our movie source is going to fetch new content
            val pagedListConfig = PagedList.Config.Builder()
                .setPageSize(20) // amount of items per page
                .setPrefetchDistance(60) // amount of items pre-fetched, must be a lot bigger than setPageSize per paging documentation
                .setEnablePlaceholders(true) // enabled pages with NULL movies while data is loading, so we can present placeholders properly
                .build()

            movies = LivePagedListBuilder(MovieSourceFactory(), pagedListConfig).build()
        }

        return movies
    }
}