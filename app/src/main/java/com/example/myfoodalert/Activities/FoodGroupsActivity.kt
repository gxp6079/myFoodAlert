package com.example.myfoodalert.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.myfoodalert.Datatypes.FoodType
import com.example.myfoodalert.R
import kotlinx.android.synthetic.main.activity_foodgroups.*

class FoodGroupsActivity: AppCompatActivity() {

    enum class FoodGroup{
        CARBOHYDRATES,
        PROTAINS,
        DAIRY,
        FRUITS_AND_VEGETABLES,
        FATS_AND_SUGARS
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foodgroups)

        carbs_item.title.text = "Carbohydrates"
        carbs_item.imageView.setImageResource(R.drawable.carb_image)
        carbs_item.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext, FoodGroupPageActivity::class.java)
                intent.putExtra("FoodGroup", FoodGroup.CARBOHYDRATES)
                intent.putExtra("example", FoodType("Breads, fresh", FoodGroup.CARBOHYDRATES, "3-5 days"))
                startActivity(intent)
            }
        })

        proteins_item.title.text = "Proteins"
        proteins_item.imageView.setImageResource(R.drawable.proteins_image)
        proteins_item.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext, FoodGroupPageActivity::class.java)
                intent.putExtra("FoodGroup", FoodGroup.PROTAINS)
                intent.putExtra("example", FoodType("Breads, fresh", FoodGroup.CARBOHYDRATES, "3-5 days"))
                startActivity(intent)
            }
        })

        dairy_item.title.text = "Milk and dairy"
        dairy_item.imageView.setImageResource(R.drawable.dairy_image)
        dairy_item.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext, FoodGroupPageActivity::class.java)
                intent.putExtra("FoodGroup", FoodGroup.DAIRY)
                intent.putExtra("example", FoodType("Cream Cheese", FoodGroup.DAIRY, refrigetatorLife = "2 weeks"))
                startActivity(intent)
            }
        })

        fruits_and_veg_item.title.text = "Fruits and vegetables"
        fruits_and_veg_item.imageView.setImageResource(R.drawable.fruits_veg_image)
        fruits_and_veg_item.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext, FoodGroupPageActivity::class.java)
                intent.putExtra("FoodGroup", FoodGroup.FRUITS_AND_VEGETABLES)
                intent.putExtra("example", FoodType("Grapefruit", FoodGroup.FRUITS_AND_VEGETABLES, "7 days", "2 weeks", "4-6 months"))
                startActivity(intent)
            }
        })

        fats_sugars_item.title.text = "Fats and sugars"
        fats_sugars_item.imageView.setImageResource(R.drawable.fats_sugars_image)
        fats_sugars_item.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext, FoodGroupPageActivity::class.java)
                intent.putExtra("FoodGroup", FoodGroup.FATS_AND_SUGARS)
                intent.putExtra("example", FoodType("Breads, fresh", FoodGroup.CARBOHYDRATES, "3-5 days"))
                startActivity(intent)
            }
        })
    }
}