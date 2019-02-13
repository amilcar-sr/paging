package com.codesgood.paging.network.sourcefactory

import androidx.paging.DataSource
import com.codesgood.paging.model.Movie
import com.codesgood.paging.network.datasource.MovieSource

class MovieSourceFactory : DataSource.Factory<Int, Movie>() {

    /**
     * Returns an instance of our MovieSource, this class is needed to take advantage of the LivePagedListBuilder
     * we don't wanna do all the work that builder does for us.
     */
    override fun create(): DataSource<Int, Movie> {
        return MovieSource()
    }
}