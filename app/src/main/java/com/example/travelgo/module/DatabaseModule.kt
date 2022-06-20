package com.example.travelgo.module

import com.example.travelgo.utils.PaperPrefs
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbModule = module {
    single { PaperPrefs(androidApplication()) }
}