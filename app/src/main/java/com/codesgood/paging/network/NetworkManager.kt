package com.codesgood.paging.network

import com.codesgood.paging.model.MovieListResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkManager {

    companion object {

        private const val API_KEY = "api_key"
        private const val BASE_API_URL = "https://api.themoviedb.org/3/"
        const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w342"

        private lateinit var apiService: MovieAPI

        fun init() {
            val client = OkHttpClient.Builder().addInterceptor {
                var request = it.request()
                val url = request.url().newBuilder().addQueryParameter(API_KEY, PrivateConstants.API_KEY).build()
                request = request.newBuilder().url(url).build()
                it.proceed(request)
            }.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()


            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            apiService = retrofit.create(MovieAPI::class.java)
        }

        fun getPopularMoviesPage(page: Int): MovieListResponse? {
            return apiService.getMovies(page).execute().body()
        }
    }
}