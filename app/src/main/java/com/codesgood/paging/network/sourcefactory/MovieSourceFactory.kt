package com.codesgood.paging.network.sourcefactory

import androidx.paging.DataSource
import com.codesgood.paging.model.Movie
import com.codesgood.paging.network.datasource.MovieSource

class MovieSourceFactory : DataSource.Factory<Int, Movie>() {

    override fun create(): DataSource<Int, Movie> {
        return MovieSource()
    }
}