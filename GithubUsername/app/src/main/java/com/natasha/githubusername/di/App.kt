package com.natasha.githubusername.di

import android.app.Application
import com.natasha.githubusername.di.component.AppComponent

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        
    }
}

lateinit var component: AppComponent