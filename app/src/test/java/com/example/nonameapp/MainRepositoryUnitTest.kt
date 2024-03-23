//package com.example.nonameapp
//
//import android.content.Context
//import com.example.nonameapp.data.CacheSession
//import com.example.nonameapp.data.SharedPreferenceHelper
//import com.example.nonameapp.domain.GetAllDishesByCategoryUseCase
//import kotlinx.coroutines.test.runTest
//import org.junit.Assert
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.Mock
//import org.mockito.junit.MockitoJUnitRunner
//
//@RunWith(MockitoJUnitRunner::class)
//class MainRepositoryUnitTest {
//    private lateinit var cacheSession: CacheSession
//    private lateinit var repository: MainRepository
//    private lateinit var getAllDishesByCategoryUseCase: GetAllDishesByCategoryUseCase
//
//    @Mock
//    private lateinit var mockContext: Context
//
//    @Before
//    fun setup() {
//        cacheSession = CacheSession()
//        repository = MainRepository(SharedPreferenceHelper(mockContext), cacheSession)
//        getAllDishesByCategoryUseCase = GetAllDishesByCategoryUseCase(repository)
//    }
//
//    @Test
//    fun getDishesByCategory_emptyCacheSession() {
//        runTest {
//            val listDishes = getAllDishesByCategoryUseCase("Side dishes")
//            Assert.assertEquals(2, listDishes?.size)
//        }
//    }
//}