package alfianyusufabdullah.githubsearch.main

import alfianyusufabdullah.githubsearch.common.Dummy
import alfianyusufabdullah.githubsearch.data.repository.MainRepositoryImpl
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var observer: Observer<MainViewModelState>

    @Mock
    lateinit var mainRepositoryImpl: MainRepositoryImpl

    private lateinit var mainViewModel: MainViewModel

    private val expectedResponse = Dummy.getDummyData
    private val expectedFailed = "test expected throwable"

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        mainViewModel = MainViewModel(mainRepositoryImpl)
    }

    @Test
    fun `test should be success to observe data`() {
        val expected = MutableLiveData<MainViewModelState>()
        expected.postValue(OnResponse(expectedResponse))

        Mockito.`when`(mainRepositoryImpl.doSearch(any())).thenReturn(expected)

        mainViewModel.doSearch(ArgumentMatchers.anyString())
        mainViewModel.dataState.observeForever(observer)

        verify(observer).onChanged(OnResponse(expectedResponse))
    }

    @Test
    fun `test should be failed to retrieve data`() {
        val expected = MutableLiveData<MainViewModelState>()
        expected.postValue(OnFailed(expectedFailed))

        Mockito.`when`(mainRepositoryImpl.doSearch(any())).thenReturn(expected)

        mainViewModel.doSearch(ArgumentMatchers.anyString())
        mainViewModel.dataState.observeForever(observer)

        verify(observer).onChanged(OnFailed(expectedFailed))

        Assert.assertEquals(expected.value, mainViewModel.dataState.value)
    }

    @Test
    fun `test assert value of data`() {
        val expected = MutableLiveData<MainViewModelState>()
        expected.postValue(OnResponse(expectedResponse))

        Mockito.`when`(mainRepositoryImpl.doSearch(any())).thenReturn(expected)

        mainViewModel.doSearch(ArgumentMatchers.anyString())
        mainViewModel.dataState.observeForever(observer)

        Assert.assertNotNull((mainViewModel.dataState.value as OnResponse).data)

        expectedResponse.forEachIndexed { index, expectedValue ->
            val actualValue = mainViewModel.dataState.value as OnResponse

            Assert.assertEquals(expectedValue.name, actualValue.data[index].name)
            Assert.assertEquals(expectedValue.age, actualValue.data[index].age)
        }
    }
}