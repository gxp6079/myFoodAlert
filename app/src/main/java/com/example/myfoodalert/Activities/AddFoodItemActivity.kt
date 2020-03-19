package com.example.myfoodalert.Activities

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
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

    lateinit var foodList: RecyclerView
    lateinit var foodSearch: SearchView
    lateinit var foodListAdapter: FoodListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_shopping_list)

        foodList = food_list
        foodSearch = food_search
        val notFoundItem = FoodType("Food not found")

        val listOfFoods = ArrayList<FoodType>()
        listOfFoods.add(FoodType("Breads, fresh", FoodGroupsActivity.FoodGroup.CARBOHYDRATES.name, "3-5 days"))
        listOfFoods.add(FoodType("American Cheese", FoodGroupsActivity.FoodGroup.CARBOHYDRATES.name, "3-5 days"))
        listOfFoods.add(FoodType("Coco Powder", FoodGroupsActivity.FoodGroup.CARBOHYDRATES.name, "3-5 days"))
        listOfFoods.add(FoodType("Dried fruits cooked", FoodGroupsActivity.FoodGroup.CARBOHYDRATES.name, "3-5 days"))
        listOfFoods.add(FoodType("Eggs", FoodGroupsActivity.FoodGroup.CARBOHYDRATES.name, "3-5 days"))
        listOfFoods.add(FoodType("Fondant", FoodGroupsActivity.FoodGroup.CARBOHYDRATES.name, "3-5 days"))

        listOfFoods.add(notFoundItem)

        foodListAdapter = FoodListAdapter(listOfFoods, applicationContext, notFoundItem)

        foodSearch.setOnQueryTextListener(this)
        foodList.apply {
            layoutManager = LinearLayoutManager(this@AddFoodItemActivity)
            adapter = foodListAdapter
        }
    }


    override fun onQueryTextSubmit(p0: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        foodListAdapter.filter(p0 ?: "")
        return false
    }

}

class FoodListAdapter(val items: ArrayList<FoodType>, val context: Context, val notFoundItem: FoodType): RecyclerView.Adapter<FoodItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): FoodItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food_item, parent, false)
        return FoodItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemsDisplaying.size
    }

    override fun onBindViewHolder(holder: FoodItemViewHolder, index: Int) {
        val item = itemsDisplaying[index]
        holder.name.text = item.name
        if(item.foodGroup.isNotBlank()) {
            holder.roomLife.text = item.roomTemperatureLife
            holder.refrigeratorLife.text = item.refrigetatorLife
            holder.freezerLife.text = item.freezerLife
            holder.name.background = ResourcesCompat.getDrawable(context.resources, R.drawable.image_border, null)
        }
        else{
            holder.roomLife.visibility = View.GONE
            holder.refrigeratorLife.visibility = View.GONE
            holder.freezerLife.visibility = View.GONE
            holder.image.visibility = View.GONE
            holder.name.background = ResourcesCompat.getDrawable(context.resources, R.drawable.button_background, null)
        }
    }

    val itemsDisplaying = ArrayList<FoodType>()

    init {
        itemsDisplaying.addAll(items)
        notifyDataSetChanged()
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
        itemsDisplaying.add(notFoundItem)
        notifyDataSetChanged()
    }

}

class FoodItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val image: ImageView
    val name: TextView
    val roomLife: TextView
    val refrigeratorLife: TextView
    val freezerLife: TextView

    init {
        image = itemView.findViewById(R.id.food_type_image)
        name = itemView.findViewById(R.id.food_name)
        roomLife = itemView.findViewById(R.id.room_shelf_life)
        refrigeratorLife = itemView.findViewById(R.id.refrigerator_shelf_life)
        freezerLife = itemView.findViewById(R.id.frozen_shelf_life)
    }
}

