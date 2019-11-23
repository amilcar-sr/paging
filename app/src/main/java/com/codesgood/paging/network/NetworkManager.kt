package com.codesgood.paging.network

import com.codesgood.paging.model.MovieListResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkManager {

    companion object {

        //Query param for the secret key required by The Movie Database API
        private const val API_KEY_PARAM = "api_key"

        //Base URL of The Movie Database API
        private const val BASE_API_URL = "https://api.themoviedb.org/3/"

        //Base URL of images retrieved by The Movie Database API
        const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w200"

        //Singleton instance of the API service
        private lateinit var apiService: MovieAPI

        /**
         * Configures/Initializes the API service we'll use for the HTTP requests
         */
        fun init() {
            //OkHttpClient that will add the API key and the logs for the requests (we want to see those)
            val client = OkHttpClient.Builder().addInterceptor {
                var request = it.request()
                val url = request.url().newBuilder().addQueryParameter(API_KEY_PARAM, PrivateConstants.API_KEY).build()
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

        /**
         * Returns a list of movies according to the page number
         * @param page number to be fetched
         */
        fun getPopularMoviesPage(page: Int): MovieListResponse? {
            return apiService.getPopularMovies(page).execute().body()
        }
    }
}