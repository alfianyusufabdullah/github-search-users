package alfianyusufabdullah.githubsearch.main

import alfianyusufabdullah.githubsearch.common.Dummy
import alfianyusufabdullah.githubsearch.data.repository.MainRepository
import alfianyusufabdullah.githubsearch.data.repository.MainRepositoryCallback
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var observer: Observer<MainViewModelState>

    @Mock
    lateinit var mainRepository: MainRepository

    lateinit var mainViewModel: MainViewModel

    private val expectedResponse = Dummy.getDummyData
    private val expectedFailed = "test expected throwable"

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        mainViewModel = MainViewModel(mainRepository)
    }

    @Test
    fun `test should be success to observe data`() {
        mainViewModel.requestData()

        argumentCaptor<MainRepositoryCallback>().apply {
            verify(mainRepository).requestData(capture())
            firstValue.onResponse(expectedResponse)
        }

        mainViewModel.dataState.observeForever(observer)

        verify(observer).onChanged(OnResponse(expectedResponse))
    }

    @Test
    fun `test should be failed to retrieve data`() {
        mainViewModel.requestData()

        argumentCaptor<MainRepositoryCallback>().apply {
            verify(mainRepository).requestData(capture())
            firstValue.onFailed(Throwable(expectedFailed))
        }

        mainViewModel.dataState.observeForever(observer)

        verify(observer).onChanged(OnFailed(expectedFailed))
    }

    @Test
    fun `test assert value of data`() {
        mainViewModel.requestData()

        argumentCaptor<MainRepositoryCallback>().apply {
            verify(mainRepository).requestData(capture())
            firstValue.onResponse(expectedResponse)
        }

        Assert.assertNotNull(mainViewModel.dataState.value)
        Assert.assertNotNull((mainViewModel.dataState.value as OnResponse).data)

        expectedResponse.forEachIndexed { index, expectedValue ->
            val actualValue = mainViewModel.dataState.value as OnResponse

            Assert.assertEquals(expectedValue.name, actualValue.data[index].name)
            Assert.assertEquals(expectedValue.age, actualValue.data[index].age)
        }
    }
}