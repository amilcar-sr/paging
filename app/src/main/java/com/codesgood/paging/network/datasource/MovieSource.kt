package com.codesgood.paging.network.datasource

import androidx.paging.PageKeyedDataSource
import com.codesgood.paging.model.Movie
import com.codesgood.paging.network.NetworkManager

class MovieSource : PageKeyedDataSource<Int, Movie>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {
        val movies = NetworkManager.getPopularMoviesPage(1)
        callback.onResult(movies!!.results.toMutableList(), null, movies.page + 1)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        val moviePageResponse = NetworkManager.getPopularMoviesPage(params.key)
        if (moviePageResponse != null) {
            val isLastPage = params.key >= moviePageResponse.totalPages
            val movies = moviePageResponse.results.toMutableList()
            callback.onResult(movies, if (isLastPage) null else moviePageResponse.page + 1)
        } else {

        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        val moviePageResponse = NetworkManager.getPopularMoviesPage(params.key)
        if (moviePageResponse != null) {
            val isLastPage = params.key == 1
            val movies = moviePageResponse.results.toMutableList()
            callback.onResult(movies, if (isLastPage) null else moviePageResponse.page - 1)
        }
    }
}