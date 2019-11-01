package com.natasha.githubusername.di.component

import com.natasha.githubusername.MainActivity
import com.natasha.githubusername.di.module.AppModule
import com.natasha.githubusername.di.module.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {
    fun inject(activity: MainActivity)
}