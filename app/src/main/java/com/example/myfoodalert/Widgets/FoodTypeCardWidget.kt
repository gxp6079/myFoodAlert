package com.example.myfoodalert.Widgets

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.myfoodalert.R
import kotlinx.android.synthetic.main.item_food_item.view.*
import kotlinx.android.synthetic.main.item_foodgroup_icon.view.*

class FoodTypeCardWidget  @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {
    var imageView: ImageView
    var title: TextView
    var roomTemp: TextView
    var refTemp: TextView
    var freezTemp: TextView

    init {
        View.inflate(context, R.layout.item_food_item, this )
        imageView = food_type_image
        title = food_name
        roomTemp = room_shelf_life
        refTemp = refrigerator_shelf_life
        freezTemp = frozen_shelf_life
    }


}