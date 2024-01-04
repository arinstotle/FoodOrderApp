package com.example.nonameapp.di.modules

import com.example.nonameapp.di.scopes.ActivityScope
import com.example.nonameapp.di.scopes.AppScope
import com.example.nonameapp.viewModels.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @Provides
    @ActivityScope
    fun provideTaskViewModelFactory(

    ): ViewModelFactory = ViewModelFactory(

    )

}