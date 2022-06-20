package com.example.travelgo.module

import com.example.travelgo.utils.PaperPrefs
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val sharedclassmodule = module {

    single { PaperPrefs(androidApplication()) }

}