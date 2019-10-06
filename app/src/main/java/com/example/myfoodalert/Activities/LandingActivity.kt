package com.example.myfoodalert.Activities

import android.app.Activity
import android.arch.lifecycle.LifecycleObserver
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.myfoodalert.R
import kotlinx.android.synthetic.main.activity_landing.*

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        what_do_i_have_button.setOnClickListener( object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext, FoodGroupsActivity::class.java)
                startActivity(intent)
            }
        })
    }
}