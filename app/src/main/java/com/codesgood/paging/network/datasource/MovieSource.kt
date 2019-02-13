package com.codesgood.paging.network.datasource

import androidx.paging.PageKeyedDataSource
import com.codesgood.paging.model.Movie
import com.codesgood.paging.network.NetworkManager

class MovieSource : PageKeyedDataSource<Int, Movie>() {

    /**
     * Triggered when the first page needs to be loaded
     */
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {
        //Requesting the first page (the Movie API doesn't start with 0 for some reason)
        val movies = NetworkManager.getPopularMoviesPage(1)

        //Returning movies retrieved from endpoint, null in the 2nd param because there is no previous page,
        //and the next page number in the 3rd param
        callback.onResult(movies!!.results.toMutableList(), null, movies.page + 1)
    }

    /**
     * Triggered when NEXT page needs to be loaded
     */
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        //Requesting next page of movies
        val moviePageResponse = NetworkManager.getPopularMoviesPage(params.key)

        if (moviePageResponse != null) {
            val isLastPage = params.key >= moviePageResponse.totalPages
            val movies = moviePageResponse.results.toMutableList()

            //Returning movies retrieved from endpoint and pass NULL as 2nd param if this is the last page
            //next page number otherwise
            callback.onResult(movies, if (isLastPage) null else moviePageResponse.page + 1)
        }
    }

    /**
     * Triggered when PREVIOUS page needs to be loaded
     */
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        //Requesting previous page of movies
        val moviePageResponse = NetworkManager.getPopularMoviesPage(params.key)

        if (moviePageResponse != null) {
            val isFirstPage = params.key == 1
            val movies = moviePageResponse.results.toMutableList()

            //Returning movies retrieved from endpoint and pass NULL as 2nd param if this is the first page
            //previous page number otherwise
            callback.onResult(movies, if (isFirstPage) null else moviePageResponse.page - 1)
        }
    }
}