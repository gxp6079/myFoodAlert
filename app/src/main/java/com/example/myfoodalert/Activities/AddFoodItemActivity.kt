package com.example.myfoodalert.Activities

import android.content.Context
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.myfoodalert.Datatypes.FoodType
import com.example.myfoodalert.R
import kotlinx.android.synthetic.main.activity_add_to_shopping_list.*
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.ArrayList

class AddFoodItemActivity : AppCompatActivity(), SearchView.OnQueryTextListener{

    lateinit var foodList: ListView
    lateinit var foodSearch: SearchView
    lateinit var adapter: FoodListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_shopping_list)

        foodList = food_list
        foodSearch = food_search

        val listOfFoods = ArrayList<FoodType>()
        listOfFoods.add(FoodType("Breads, fresh", FoodGroupsActivity.FoodGroup.CARBOHYDRATES.name, "3-5 days"))
        listOfFoods.add(FoodType("American Cheese", FoodGroupsActivity.FoodGroup.CARBOHYDRATES.name, "3-5 days"))
        listOfFoods.add(FoodType("Coco Powder", FoodGroupsActivity.FoodGroup.CARBOHYDRATES.name, "3-5 days"))
        listOfFoods.add(FoodType("Dried fruits cooked", FoodGroupsActivity.FoodGroup.CARBOHYDRATES.name, "3-5 days"))
        listOfFoods.add(FoodType("Eggs", FoodGroupsActivity.FoodGroup.CARBOHYDRATES.name, "3-5 days"))
        listOfFoods.add(FoodType("Fondant", FoodGroupsActivity.FoodGroup.CARBOHYDRATES.name, "3-5 days"))


        adapter = FoodListAdapter(listOfFoods, applicationContext)

        foodSearch.setOnQueryTextListener(this)
        foodList.adapter = adapter
    }


    override fun onQueryTextSubmit(p0: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        adapter.filter(p0 ?: "")
        return false
    }

}

class FoodListAdapter(val items: ArrayList<FoodType>, val context: Context): BaseAdapter() {
    val itemsDisplaying = ArrayList<FoodType>()

    init {
        itemsDisplaying.addAll(items)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holder: FoodItemViewHolder
        val view: View
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_food_item, null)
            holder = FoodItemViewHolder(view)
            view.setTag(holder)
        }
        else {
            view = convertView
            holder = convertView.getTag() as FoodItemViewHolder
        }
        val item = itemsDisplaying[position]
        holder.name.text = item.name
        holder.roomLife.text = item.roomTemperatureLife
        holder.refrigeratorLife.text = item.refrigetatorLife
        holder.freezerLife.text = item.freezerLife
        return view
    }

    // Filter Class
    fun filter(charText : String) {
        itemsDisplaying.clear()
        if (charText.length == 0) {
            itemsDisplaying.addAll(items)
        } else {
            for (foodType in items) {
                if (foodType.name.toLowerCase().contains(charText.toLowerCase())) {
                    itemsDisplaying.add(foodType)
                }
            }
        }
        notifyDataSetChanged()
    }


    override fun getItem(position: Int): FoodType {
        return itemsDisplaying[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getCount(): Int {
        return itemsDisplaying.size
    }
}

class FoodItemViewHolder(view: View){
    val image: ImageView
    val name: TextView
    val roomLife: TextView
    val refrigeratorLife: TextView
    val freezerLife: TextView

    init {
        image = view.findViewById(R.id.food_type_image)
        name = view.findViewById(R.id.food_name)
        roomLife = view.findViewById(R.id.room_shelf_life)
        refrigeratorLife = view.findViewById(R.id.refrigerator_shelf_life)
        freezerLife = view.findViewById(R.id.frozen_shelf_life)
    }
}

