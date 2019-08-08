package alfianyusufabdullah.viewmodeltestdrive.data.repository

import alfianyusufabdullah.viewmodeltestdrive.data.source.MainDataSource

class MainRepository(private val dataSource: MainDataSource) {

    fun requestData(mainRepositoryCallback: MainRepositoryCallback) {
        val response = dataSource.requestMainData()
        response?.let {
            mainRepositoryCallback.onResponse(it)
        }.run {
            mainRepositoryCallback.onFailed(Throwable("Data is null!"))
        }
    }

}