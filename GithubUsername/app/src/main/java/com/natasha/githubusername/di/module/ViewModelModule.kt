package com.natasha.githubusername.di.module

import com.natasha.githubusername.MainViewModel
import com.natasha.githubusername.MainViewModelFactory
import com.natasha.githubusername.service.Api
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun providesMainViewModelFactory(api: Api): MainViewModelFactory {
        return MainViewModelFactory(api)
    }
}