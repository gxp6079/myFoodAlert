package com.example.myfoodalert.Activities

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.myfoodalert.Datatypes.FoodType
import com.example.myfoodalert.R

class ShoppingListFragment : Fragment() {
    val shoppingList = ArrayList<FoodType>()
    lateinit var myadapter : ShoppingListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_my_shopping_list, container, false)
        val addButton = view.findViewById<Button>(R.id.add_food_item_button)
        val foodList = view.findViewById<RecyclerView>(R.id.food_list)
        myadapter = ShoppingListAdapter(shoppingList)

        addButton.setOnClickListener {
            (activity as ShoppingListActivity).goToAddItem()
        }

        foodList.apply {
            adapter = myadapter
            layoutManager = LinearLayoutManager(context)
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        myadapter.items = shoppingList
        myadapter.notifyDataSetChanged()
    }
}

class ShoppingListAdapter(var items: ArrayList<FoodType>): RecyclerView.Adapter<ShoppingItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ShoppingItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shopping_list, parent, false)
        return ShoppingItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, idx: Int) {
        val item = items[idx]
        holder.name.text = item.name
        holder.removeButton.setOnClickListener {
            items.remove(item)
            notifyDataSetChanged()
        }
    }

}

class ShoppingItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val image: ImageView
    val name: TextView
    val removeButton: Button

    init {
        image = itemView.findViewById(R.id.food_type_image)
        name = itemView.findViewById(R.id.item_name)
        removeButton = itemView.findViewById(R.id.add_food_item_button)
    }
}