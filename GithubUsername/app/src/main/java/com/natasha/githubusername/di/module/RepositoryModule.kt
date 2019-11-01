package com.natasha.githubusername.di.module

import com.natasha.githubusername.repository.UserRepository
import com.natasha.githubusername.repository.UserRepositoryImpl
import com.natasha.githubusername.service.Api
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesUserRepository(api: Api) : UserRepository {
        return UserRepositoryImpl(api)
    }
}