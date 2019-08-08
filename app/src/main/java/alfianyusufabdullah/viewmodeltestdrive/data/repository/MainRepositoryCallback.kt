package alfianyusufabdullah.viewmodeltestdrive.data.repository

import alfianyusufabdullah.viewmodeltestdrive.data.entity.MainEntity

interface MainRepositoryCallback {
    fun onResponse(data: List<MainEntity>)
    fun onFailed(exception: Throwable)
}