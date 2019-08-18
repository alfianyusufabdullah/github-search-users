package alfianyusufabdullah.githubsearch.data.source

import alfianyusufabdullah.githubsearch.data.entity.MainEntity

interface MainDataSourceCallback {
    fun onStart()
    fun onData(list: List<MainEntity>)
    fun onError(message: String)
}