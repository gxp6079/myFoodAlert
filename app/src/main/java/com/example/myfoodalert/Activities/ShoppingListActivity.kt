package com.example.myfoodalert.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.myfoodalert.Datatypes.FoodType
import com.example.myfoodalert.R

class ShoppingListActivity: AppCompatActivity(){

    val shoppingListFragment = ShoppingListFragment()
    val addItemFragment = AddFoodItemFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.blanck_activity)
        goToShoppingList(ArrayList())
    }

    fun goToShoppingList(toAdd: ArrayList<FoodType>){
        shoppingListFragment.shoppingList.addAll(toAdd)
        supportFragmentManager.beginTransaction()
                .addToBackStack("shopping_list")
                .replace(R.id.container, shoppingListFragment)
                .commit()
    }

    fun goToAddItem(){
        supportFragmentManager.beginTransaction()
                .addToBackStack("add_food_to_db")
                .replace(R.id.container, addItemFragment)
                .commit()
    }

    fun showNewFoodDialog(){
        NewFoodTypeDialog(addItemFragment).show(supportFragmentManager, "dialog")
    }
}