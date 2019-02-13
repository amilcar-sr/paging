package com.codesgood.paging.network

import com.codesgood.paging.model.MovieListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    /**
     * Popular movies endpoint/call
     */
    @GET("movie/popular")
    fun getPopularMovies(@Query("page") page: Int): Call<MovieListResponse>
}