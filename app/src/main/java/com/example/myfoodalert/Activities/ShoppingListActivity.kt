package com.example.myfoodalert.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.myfoodalert.Datatypes.FoodType
import com.example.myfoodalert.R
import kotlinx.android.synthetic.main.activity_my_shopping_list.*

class ShoppingListActivity: AppCompatActivity(){

    val shoppingListFragment = ShoppingListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.black_activity)
        goToShoppingList(ArrayList())
    }

    fun goToShoppingList(toAdd: ArrayList<FoodType>){
        shoppingListFragment.shoppingList.addAll(toAdd)
        supportFragmentManager.beginTransaction()
                .addToBackStack("add_food")
                .replace(R.id.container, shoppingListFragment)
                .commit()
    }

    fun goToAddItem(){
        supportFragmentManager.beginTransaction()
                .addToBackStack("add_food")
                .replace(R.id.container, AddFoodItemFragment())
                .commit()
    }
}