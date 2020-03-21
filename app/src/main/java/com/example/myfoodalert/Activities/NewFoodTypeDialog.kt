package com.example.myfoodalert.Activities

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.example.myfoodalert.R



class NewFoodTypeDialog : DialogFragment() {

    val foodGroups = arrayOf("Carbohydrates", "Proteins", "Milk and dairy", "Fruits and vegetables", "Fats and sugars")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater.inflate(R.layout.add_to_food_db, container, false)
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
            this.dismiss()
        }

        val spinner = view.findViewById<Spinner>(R.id.food_type_spinner)
        val aa = ArrayAdapter(context, android.R.layout.simple_spinner_item, foodGroups)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = aa

        super.onViewCreated(view, savedInstanceState)
    }
}