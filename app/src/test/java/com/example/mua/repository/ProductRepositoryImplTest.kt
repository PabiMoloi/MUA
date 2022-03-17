package com.example.mua.repository

import com.example.mua.mockProducts
import com.example.mua.network.RetrofitService
import junit.framework.Assert.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.anyString
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import retrofit2.Response

@ExperimentalCoroutinesApi
class ProductRepositoryImplTest {

    @Mock
    lateinit var retrofitService: RetrofitService
    private lateinit var repository: ProductRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = ProductRepositoryImpl(retrofitService)
    }

    @Test
    fun getProductsByType_responseSuccess_returnsProductList() {
        runBlocking {
            `when`(retrofitService.getProductsByType(anyString())).thenReturn(
                Response.success(
                    mockProducts()
                )
            )
            val response = repository.getProductsByType(anyString())
            assertNotNull(response)
            verify(retrofitService).getProductsByType(anyString())
            assertEquals(response.body(), mockProducts())
        }
    }

    @Test
    fun getProductsByType_responseUnsuccessful_returnsError() {
        runBlocking {
            val errorMessage = "Bad Request"
            `when`(retrofitService.getProductsByType(anyString())).thenReturn(
                Response.error(
                    400, ResponseBody.create(
                        MediaType.parse("application/json"), "Bad Request"
                    )
                )
            )
            val response = repository.getProductsByType(anyString())
            assertNotNull(response)
            assertEquals(errorMessage, response.errorBody()?.byteStream()?.bufferedReader().use { it?.readText() })
        }
    }
}