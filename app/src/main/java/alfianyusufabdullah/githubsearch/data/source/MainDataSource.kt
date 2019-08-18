package alfianyusufabdullah.githubsearch.data.source

import alfianyusufabdullah.githubsearch.data.entity.MainEntity

class MainDataSource {

    /**
     * should be replace with real network request, ieu
     */
    fun doSearch(username: String, mainDataSourceCallback: MainDataSourceCallback) {
        mainDataSourceCallback.onStart()
        if (username.isEmpty()) {
            mainDataSourceCallback.onError("Username is empty")
        } else {
            val data = Array(10) {
                MainEntity("Name $it", 4 * it)
            }
            mainDataSourceCallback.onData(data.toList())
        }
    }
}