package com.shyam.schoolslist.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shyam.schoolslist.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, SchoolsListFragment.newInstance())
                .commitNow()
        }
    }
}