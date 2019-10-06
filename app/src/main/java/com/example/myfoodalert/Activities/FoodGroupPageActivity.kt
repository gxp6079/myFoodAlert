package com.example.myfoodalert.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.myfoodalert.Datatypes.FoodType
import com.example.myfoodalert.R
import com.example.myfoodalert.Widgets.FoodTypeCardWidget
import kotlinx.android.synthetic.main.activity_food_group.*
import kotlinx.android.synthetic.main.activity_foodgroups.*

class FoodGroupPageActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_group)

        food_group_page_title.text = intent.getStringExtra("FoodGroup")

        val exType = intent.getParcelableExtra<FoodType>("example")

        var child = FoodTypeCardWidget(applicationContext)
        child.title.text = exType.name
        if(!exType.roomTemperatureLife.isNullOrEmpty()) {
            child.roomTemp.text = resources.getString(R.string.room_temp_shelf_life_string).format(exType.roomTemperatureLife)
        }
        else{
            child.roomTemp.text = resources.getString(R.string.should_not_be_maintained_in_room_temp)
        }
        if(!exType.refrigetatorLife.isNullOrEmpty()) {
            child.roomTemp.text = resources.getString(R.string.ref_shelf_life_string).format(exType.refrigetatorLife)
        }
        else {
            child.roomTemp.text = resources.getString(R.string.should_not_be_maintained_in_ref)

        }
        if(!exType.freezerLife.isNullOrEmpty()) {
            child.roomTemp.text = resources.getString(R.string.frozen_shelf_life_string).format(exType.freezerLife)
        }
        else {
            child.roomTemp.text = resources.getString(R.string.should_not_be_frozen)
        }


            food_types_insert_point.addView(child)

    }
}