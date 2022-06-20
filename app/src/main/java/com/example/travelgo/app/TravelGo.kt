package com.example.travelgo.app

import android.content.Context
import androidx.multidex.BuildConfig
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.example.travelgo.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class TravelGo: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
        startKoin {
            androidContext(this@TravelGo)
            modules(listOf(networkModule, repoModule, viewModelModule, dbModule, sharedclassmodule))
        }

    }

    private fun initTimber() {
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}
