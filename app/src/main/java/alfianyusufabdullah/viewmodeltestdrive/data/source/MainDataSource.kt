package alfianyusufabdullah.viewmodeltestdrive.data.source

import alfianyusufabdullah.viewmodeltestdrive.data.entity.MainEntity

class MainDataSource {

    fun requestMainData(): MutableList<MainEntity>? = mutableListOf(
        MainEntity("Alfian", 18),
        MainEntity("Yusuf", 15),
        MainEntity("Abdullah", 14)
    )
}