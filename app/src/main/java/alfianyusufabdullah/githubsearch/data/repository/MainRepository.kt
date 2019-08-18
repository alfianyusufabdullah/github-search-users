package alfianyusufabdullah.githubsearch.data.repository

import alfianyusufabdullah.githubsearch.main.MainViewModelState
import androidx.lifecycle.MutableLiveData

interface MainRepository {
    fun doSearch(username: String): MutableLiveData<MainViewModelState>
}