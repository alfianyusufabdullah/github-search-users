package alfianyusufabdullah.viewmodeltestdrive.main

import alfianyusufabdullah.viewmodeltestdrive.data.entity.MainEntity
import alfianyusufabdullah.viewmodeltestdrive.data.repository.MainRepository
import alfianyusufabdullah.viewmodeltestdrive.data.repository.MainRepositoryCallback
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