package com.codesgood.paging.model

import com.google.gson.annotations.SerializedName


data class MovieListResponse(
    @SerializedName("page") var page: Int = 0,
    @SerializedName("total_results") var totalResults: Int = 0,
    @SerializedName("total_pages") var totalPages: Int = 0,
    @SerializedName("results") var results: List<Movie>
)