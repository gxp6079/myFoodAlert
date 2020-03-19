package com.example.myfoodalert.Activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myfoodalert.Datatypes.FoodType
import com.example.myfoodalert.R

class ShoppingListFragment : Fragment() {
    val shoppingList = ArrayList<FoodType>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_my_shopping_list, container, false)
        val addButton = view.findViewById<Button>(R.id.add_food_item_button)
        addButton.setOnClickListener {
            (activity as ShoppingListActivity).goToAddItem()
        }
        return view
    }
}