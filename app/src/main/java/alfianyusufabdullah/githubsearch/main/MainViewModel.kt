package alfianyusufabdullah.githubsearch.main

import alfianyusufabdullah.githubsearch.data.repository.MainRepositoryImpl
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val mainRepositoryImpl: MainRepositoryImpl) : ViewModel() {

    var dataState = MutableLiveData<MainViewModelState>()

    fun doSearch(username: String) {
        dataState = mainRepositoryImpl.doSearch(username)
    }
}