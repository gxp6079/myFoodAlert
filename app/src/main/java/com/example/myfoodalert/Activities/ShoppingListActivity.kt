package com.example.myfoodalert.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.myfoodalert.R
import kotlinx.android.synthetic.main.activity_my_shopping_list.*

class ShoppingListActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_shopping_list)

        add_food_item_button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext, AddFoodItemActivity::class.java)
                startActivity(intent)
            }
        })
    }
}