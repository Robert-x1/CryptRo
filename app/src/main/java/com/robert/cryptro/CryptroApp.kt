package com.robert.cryptro

import android.app.Application
import com.robert.cryptro.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CryptroApp: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CryptroApp)
            androidLogger()
            modules(appModule)
        }
    }
}