package com.romeroblanca.rijksmuseum

import android.app.Application
import com.romeroblanca.rijksmuseum.di.dataModule
import com.romeroblanca.rijksmuseum.di.domainModule
import com.romeroblanca.rijksmuseum.di.presentationModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class RijksmuseumApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.INFO
                } else {
                    Level.NONE
                }
            )
            androidContext(this@RijksmuseumApplication)
            modules(
                presentationModule,
                domainModule,
                dataModule
            )
        }
    }
}