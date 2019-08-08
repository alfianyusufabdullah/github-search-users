package alfianyusufabdullah.viewmodeltestdrive.main

import alfianyusufabdullah.viewmodeltestdrive.data.entity.MainEntity

sealed class MainViewModelState

data class OnResponse(val data: List<MainEntity>) : MainViewModelState()
data class OnFailed(val error: String): MainViewModelState()