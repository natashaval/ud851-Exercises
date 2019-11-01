package com.natasha.githubusername.di

import android.app.Application
import com.natasha.githubusername.di.component.AppComponent
import com.natasha.githubusername.di.component.DaggerAppComponent

class App : Application() {
    override fun onCreate() {
        super.onCreate()
            component = DaggerAppComponent.builder()
                .build()
    }
}

lateinit var component: AppComponent