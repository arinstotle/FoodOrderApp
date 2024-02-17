package com.example.nonameapp.di.components

import com.example.nonameapp.FoodApplication
import com.example.nonameapp.MainActivity
import com.example.nonameapp.di.modules.DomainModule
import com.example.nonameapp.di.modules.ViewModelModule
import com.example.nonameapp.di.scopes.ActivityScope
import com.example.nonameapp.viewModels.AuthorizationViewModel
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = ([DomainModule::class, ViewModelModule::class]))
interface ActivityComponent {

    fun inject(activity: MainActivity)

}