package com.example.nonameapp.di.modules

import com.example.nonameapp.MainRepository
import com.example.nonameapp.di.scopes.ActivityScope
import com.example.nonameapp.domain.AddToCartUseCase
import com.example.nonameapp.domain.DecreaseDishQuantityUseCase
import com.example.nonameapp.domain.GetAllDishesByCategoryUseCase
import com.example.nonameapp.domain.GetAllDishesInCartFlowUseCase
import com.example.nonameapp.domain.GetAllDishesUseCase
import com.example.nonameapp.domain.GetAllRestaurantsUseCase
import com.example.nonameapp.domain.GetAllTablesUseCase
import com.example.nonameapp.domain.GetCurrentDishInDishInfoUseCase
import com.example.nonameapp.domain.GetCurrentRestaurantUseCase
import com.example.nonameapp.domain.GetSumCartFlowUseCase
import com.example.nonameapp.domain.IncreaseDishQuantityUseCase
import com.example.nonameapp.domain.LoginByEmailUseCase
import com.example.nonameapp.domain.ReserveTableUseCase
import com.example.nonameapp.domain.SetCurrentDishInDishInfoUseCase
import com.example.nonameapp.domain.SetCurrentRestaurantUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    @ActivityScope
    fun provideLoginByEmailUseCase(repository: MainRepository): LoginByEmailUseCase =
        LoginByEmailUseCase(repository)

    @Provides
    @ActivityScope
    fun provideGetAllDishesUseCase(repository: MainRepository): GetAllDishesUseCase =
        GetAllDishesUseCase(repository)

    @Provides
    @ActivityScope
    fun provideGetAllDishesByCategoryUseCase(repository: MainRepository): GetAllDishesByCategoryUseCase =
        GetAllDishesByCategoryUseCase(repository)

    @Provides
    @ActivityScope
    fun provideReserveTableUseCase(repository: MainRepository): ReserveTableUseCase =
        ReserveTableUseCase(repository)

    @Provides
    @ActivityScope
    fun provideGetAllTablesUseCase(repository: MainRepository): GetAllTablesUseCase =
        GetAllTablesUseCase(repository)

    @Provides
    @ActivityScope
    fun provideGetAllRestaurantsUseCase(repository: MainRepository): GetAllRestaurantsUseCase =
        GetAllRestaurantsUseCase(repository)

    @Provides
    @ActivityScope
    fun provideGetCurrentRestaurantUseCase(repository: MainRepository): GetCurrentRestaurantUseCase =
        GetCurrentRestaurantUseCase(repository)

    @Provides
    @ActivityScope
    fun provideSetCurrentRestaurantUseCase(repository: MainRepository): SetCurrentRestaurantUseCase =
        SetCurrentRestaurantUseCase(repository)

    @Provides
    @ActivityScope
    fun provideGetAllDishesInCartFlowUseCase(repository: MainRepository): GetAllDishesInCartFlowUseCase =
        GetAllDishesInCartFlowUseCase(repository)

    @Provides
    @ActivityScope
    fun provideGetSumCartFlowUseCase(repository: MainRepository): GetSumCartFlowUseCase =
        GetSumCartFlowUseCase(repository)

    @Provides
    @ActivityScope
    fun provideAddToCartUseCase(repository: MainRepository): AddToCartUseCase =
        AddToCartUseCase(repository)

    @Provides
    @ActivityScope
    fun provideGetCurrentDishInDishInfo(repository: MainRepository): GetCurrentDishInDishInfoUseCase =
        GetCurrentDishInDishInfoUseCase(repository)

    @Provides
    @ActivityScope
    fun provideSetCurrentDishInDishInfo(repository: MainRepository): SetCurrentDishInDishInfoUseCase =
        SetCurrentDishInDishInfoUseCase(repository)

    @Provides
    @ActivityScope
    fun provideIncreaseDishQuantityUseCase(repository: MainRepository): IncreaseDishQuantityUseCase =
        IncreaseDishQuantityUseCase(repository)

    @Provides
    @ActivityScope
    fun provideDecreaseDishQuantityUseCase(repository: MainRepository): DecreaseDishQuantityUseCase =
        DecreaseDishQuantityUseCase(repository)
}