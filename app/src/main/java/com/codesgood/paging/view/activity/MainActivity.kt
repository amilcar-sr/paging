package com.codesgood.paging.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codesgood.paging.R
import com.codesgood.paging.view.fragment.PopularMoviesFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val popularMoviesFragment = supportFragmentManager.findFragmentByTag(PopularMoviesFragment.TAG)

        //We replace the fragment_container with the instance of PopularMoviesFragment we already had, or create a new one in case its null.
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragment_container,
                popularMoviesFragment ?: PopularMoviesFragment(),
                PopularMoviesFragment.TAG
            )
            .commit()

    }
}
