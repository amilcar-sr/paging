package com.codesgood.paging.network

import com.codesgood.paging.model.MovieListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET("movie/popular")
    fun getMovies(@Query("page") page: Int): Call<MovieListResponse>

}