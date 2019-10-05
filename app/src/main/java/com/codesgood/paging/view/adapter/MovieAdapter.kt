package com.codesgood.paging.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codesgood.paging.R
import com.codesgood.paging.model.Movie
import com.codesgood.paging.network.NetworkManager
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter : PagedListAdapter<Movie, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: Movie? = getItem(position)

        // Note that "movie" is a placeholder if it's null.
        holder.bindTo(movie)
    }

    companion object {
        //Needed by PagedListAdapter to compare items and identify content changes.
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<Movie>() {
            // The ID property identifies when items are the same.
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie) = oldItem.id == newItem.id

            // Use the "==" operator to know when an item's content changes.
            // Implement equals(), or write custom data comparison logic here.
            override fun areContentsTheSame(oldItem: Movie, newItem: Movie) = oldItem == newItem
        }
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**
         * Binds the item view to a Movie
         */
        fun bindTo(movie: Movie?) {
            val context = itemView.context
            val glide = Glide.with(context)

            //Movie loaded properly
            if (movie != null) {
                itemView.movie_name.text = movie.title
                glide.load(NetworkManager.BASE_IMAGE_URL + movie.posterPath).into(itemView.movie_poster)
            } else { //Object is null, so it's a placeholder
                itemView.movie_name.text = context.getString(R.string.loading)
                glide.load(R.drawable.popcorn_placeholder).into(itemView.movie_poster)
            }
        }
    }
}