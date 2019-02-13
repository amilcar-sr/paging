package com.codesgood.paging.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.codesgood.paging.R
import com.codesgood.paging.view.adapter.MovieAdapter
import com.codesgood.paging.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_popular_movies.*

class PopularMoviesFragment : Fragment() {

    companion object {
        const val TAG = "PopularMoviesFragment"
    }

    private val adapter = MovieAdapter()
    private lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        viewModel.getPopularMovies().observe(this, Observer { adapter.submitList(it) })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_popular_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movies_recycler.layoutManager = GridLayoutManager(context, 2)
        movies_recycler.adapter = adapter
    }
}