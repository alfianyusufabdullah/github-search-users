package alfianyusufabdullah.githubsearch.data.repository

import alfianyusufabdullah.githubsearch.data.entity.MainEntity
import alfianyusufabdullah.githubsearch.data.source.MainDataSource
import alfianyusufabdullah.githubsearch.data.source.MainDataSourceCallback
import alfianyusufabdullah.githubsearch.main.MainViewModelState
import alfianyusufabdullah.githubsearch.main.OnFailed
import alfianyusufabdullah.githubsearch.main.OnResponse
import alfianyusufabdullah.githubsearch.main.OnStart
import androidx.lifecycle.MutableLiveData

class MainRepositoryImpl(private val dataSource: MainDataSource) : MainRepository {

    override fun doSearch(username: String): MutableLiveData<MainViewModelState> {
        val data = MutableLiveData<MainViewModelState>()
        dataSource.doSearch(username, object : MainDataSourceCallback {
            override fun onStart() {
                data.postValue(OnStart)
            }

            override fun onData(list: List<MainEntity>) {
                data.postValue(OnResponse(list))
            }

            override fun onError(message: String) {
                data.postValue(OnFailed(message))
            }
        })

        return data
    }
}