package alfianyusufabdullah.viewmodeltestdrive.main

import alfianyusufabdullah.viewmodeltestdrive.R
import alfianyusufabdullah.viewmodeltestdrive.data.repository.MainRepository
import alfianyusufabdullah.viewmodeltestdrive.data.source.MainDataSource
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mainViewModel = MainViewModel(MainRepository(MainDataSource()))
        mainViewModel.dataState
    }
}
