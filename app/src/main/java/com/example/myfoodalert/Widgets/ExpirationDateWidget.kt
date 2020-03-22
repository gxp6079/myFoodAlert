package com.example.myfoodalert.Widgets

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import com.example.myfoodalert.R
import kotlinx.android.synthetic.main.item_expiration_date_entry.view.*

class ExpirationDateWidget  @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0): ConstraintLayout(context, attrs, defStyleAttr) {
    var month: EditText
    var day: EditText
    var year: EditText

    init {
        View.inflate(context, R.layout.item_expiration_date_entry, this)
        month = month_entry
        day = day_entry
        year = year_entry

        remove_expiration_type.setOnClickListener {
            remove_expiration_type.visibility = View.GONE
            month.visibility = View.GONE
            month_division.visibility = View.GONE
            day.visibility = View.GONE
            day_didsion.visibility = View.GONE
            year.visibility = View.GONE

            add_expiration_type.visibility = View.VISIBLE
        }

        add_expiration_type.setOnClickListener {
            remove_expiration_type.visibility = View.VISIBLE
            month.visibility = View.VISIBLE
            month_division.visibility = View.VISIBLE
            day.visibility = View.VISIBLE
            day_didsion.visibility = View.VISIBLE
            year.visibility = View.VISIBLE

            add_expiration_type.visibility = View.GONE
        }
    }
}