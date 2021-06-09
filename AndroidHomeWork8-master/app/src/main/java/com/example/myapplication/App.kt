package com.example.myapplication

import android.app.Application
import com.example.myapplication.api.RetrofitClient

/*
 *  Created by Nikoloz Katsitadze on 27.05.21
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        RetrofitClient.initClient()

    }

}