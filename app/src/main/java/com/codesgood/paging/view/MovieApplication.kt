package com.codesgood.paging.view

import android.app.Application
import com.codesgood.paging.network.NetworkManager


class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        NetworkManager.init()
    }
}