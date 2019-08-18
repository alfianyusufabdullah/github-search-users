package alfianyusufabdullah.githubsearch.main

import alfianyusufabdullah.githubsearch.R
import alfianyusufabdullah.githubsearch.data.repository.MainRepositoryImpl
import alfianyusufabdullah.githubsearch.data.source.MainDataSource
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = MainViewModel(MainRepositoryImpl(MainDataSource()))
        mainViewModel.dataState
    }
}