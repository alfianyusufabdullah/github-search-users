package alfianyusufabdullah.githubsearch.main

import alfianyusufabdullah.githubsearch.data.entity.MainEntity

sealed class MainViewModelState

object OnStart : MainViewModelState()
data class OnResponse(val data: List<MainEntity>) : MainViewModelState()
data class OnFailed(val error: String) : MainViewModelState()