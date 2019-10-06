package com.example.myfoodalert.Widgets

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.myfoodalert.R
import kotlinx.android.synthetic.main.item_foodgroup_icon.view.*

class FoodGroupCardWidget @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {
    var imageView: ImageView
    var title: TextView

    init {
        View.inflate(context, R.layout.item_foodgroup_icon, this )
        imageView = foodgroup_image
        title = foodgroup_title
    }


}