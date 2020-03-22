package com.example.myfoodalert.Activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.example.myfoodalert.Datatypes.FoodType
import com.example.myfoodalert.R
import com.example.myfoodalert.Widgets.ExpirationDateWidget


@SuppressLint("ValidFragment")
class NewFoodTypeDialog constructor(val parentFragment: AddFoodItemFragment) : DialogFragment() {

    val foodGroups = arrayOf("Carbohydrates", "Proteins", "Milk and dairy", "Fruits and vegetables", "Fats and sugars")
    lateinit var itemName: EditText
    lateinit var shelfLife: ExpirationDateWidget
    lateinit var fridgeLife: ExpirationDateWidget
    lateinit var frozenLife: ExpirationDateWidget
    lateinit var foodGroup: Spinner

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_add_to_food_db, container, false)

        itemName = view.findViewById(R.id.item_name)
        shelfLife = view.findViewById(R.id.shelf_expiration_date)
        fridgeLife = view.findViewById(R.id.fridge_expiration_date)
        frozenLife = view.findViewById(R.id.frozen_expiration_date)
        foodGroup = view.findViewById(R.id.food_type_spinner)

        return view
    }

    override fun onResume() {
        super.onResume()
        val width = resources.getDimensionPixelSize(R.dimen.popup_width)
        val height = resources.getDimensionPixelSize(R.dimen.popup_height)
        dialog.window!!.setLayout(width, height)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view?.findViewById<Button>(R.id.submit)?.setOnClickListener {
            // add to db
            var shelfExp = ""
            var fridgeExp = ""
            var frozenExp = ""

            if(shelfLife.month.visibility != View.GONE){
                shelfExp = "${shelfLife.month.text}/${shelfLife.day.text}/${shelfLife.year.text}"
            }

            if(fridgeLife.month.visibility != View.GONE){
                fridgeExp = "${fridgeLife.month.text}/${fridgeLife.day.text}/${fridgeLife.year.text}"
            }

            if(frozenLife.month.visibility != View.GONE){
                frozenExp = "${frozenLife.month.text}/${frozenLife.day.text}/${frozenLife.year.text}"
            }

            parentFragment.foodListAdapter.selectedItems.add(FoodType(itemName.text.toString(), foodGroup.selectedItem.toString(),
                    shelfExp, fridgeExp, frozenExp))
            this.dismiss()
        }

        val spinner = view.findViewById<Spinner>(R.id.food_type_spinner)
        val aa = ArrayAdapter(context, android.R.layout.simple_spinner_item, foodGroups)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = aa

        super.onViewCreated(view, savedInstanceState)
    }
}