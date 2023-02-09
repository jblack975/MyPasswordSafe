package com.blackfox.mypasswordsafe.android

import android.app.Application
import androidx.lifecycle.viewmodel.compose.viewModel
import com.blackfox.mypasswordsafe.android.di.androidModule
import com.blackfox.mypasswordsafe.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            modules(appModule() + androidModule)
        }
    }
}