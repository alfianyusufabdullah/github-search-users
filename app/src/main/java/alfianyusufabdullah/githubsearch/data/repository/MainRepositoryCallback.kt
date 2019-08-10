package alfianyusufabdullah.githubsearch.data.repository

import alfianyusufabdullah.githubsearch.data.entity.MainEntity

interface MainRepositoryCallback {
    fun onResponse(data: List<MainEntity>)
    fun onFailed(exception: Throwable)
}