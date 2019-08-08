package alfianyusufabdullah.viewmodeltestdrive.common

import alfianyusufabdullah.viewmodeltestdrive.data.entity.MainEntity

object Dummy {
    val getDummyData = Array(10) {
        MainEntity("Name $it", it * 10)
    }.toList()
}