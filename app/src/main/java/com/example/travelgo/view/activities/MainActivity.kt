package com.example.travelgo.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travelgo.R
import com.example.travelgo.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    }
}