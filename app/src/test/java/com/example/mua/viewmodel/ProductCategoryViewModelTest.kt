package com.example.mua.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mua.mockProducts
import com.example.mua.model.ProductState
import com.example.mua.repository.ProductRepository
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class ProductCategoryViewModelTest {

    @Mock
    lateinit var repository: ProductRepository

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()
    lateinit var viewModel: ProductCategoryViewModel
    private val mainThreadSurrogate = TestCoroutineDispatcher()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(mainThreadSurrogate)
        viewModel = ProductCategoryViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun getProductByCategory_returnsProductsByCategory() {
        runBlocking {
            launch(Dispatchers.Main) {
                Mockito.`when`(repository.getProductsByType(Mockito.anyString())).thenReturn(
                    Response.success(
                        mockProducts()
                    )
                )
                viewModel.getProductsByCategory(Mockito.anyString())
                Mockito.verify(repository).getProductsByType(Mockito.anyString())
                assertEquals(
                    (viewModel.productCategoryState.value as ProductState.Products).data,
                    mockProducts()
                )
            }
        }
    }
}