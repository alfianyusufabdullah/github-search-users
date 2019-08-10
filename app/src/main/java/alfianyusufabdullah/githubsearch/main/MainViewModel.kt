package alfianyusufabdullah.githubsearch.main

import alfianyusufabdullah.githubsearch.data.entity.MainEntity
import alfianyusufabdullah.githubsearch.data.repository.MainRepository
import alfianyusufabdullah.githubsearch.data.repository.MainRepositoryCallback
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    val dataState = MutableLiveData<MainViewModelState>()

    fun requestData() {
        mainRepository.requestData(object : MainRepositoryCallback {
            override fun onFailed(exception: Throwable) {
                dataState.postValue(OnFailed(exception.message ?: "something weird"))
            }

            override fun onResponse(data: List<MainEntity>) {
                dataState.postValue(OnResponse(data))
            }
        })
    }
}