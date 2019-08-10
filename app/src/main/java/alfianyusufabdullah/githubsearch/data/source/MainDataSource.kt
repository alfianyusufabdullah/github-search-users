package alfianyusufabdullah.githubsearch.data.source

import alfianyusufabdullah.githubsearch.data.entity.MainEntity

class MainDataSource {

    fun requestMainData(): MutableList<MainEntity>? = mutableListOf(
        MainEntity("Alfian", 18),
        MainEntity("Yusuf", 15),
        MainEntity("Abdullah", 14)
    )
}