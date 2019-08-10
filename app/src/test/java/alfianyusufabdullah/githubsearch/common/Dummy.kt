package alfianyusufabdullah.githubsearch.common

import alfianyusufabdullah.githubsearch.data.entity.MainEntity

object Dummy {
    val getDummyData = Array(10) {
        MainEntity("Name $it", it * 10)
    }.toList()
}