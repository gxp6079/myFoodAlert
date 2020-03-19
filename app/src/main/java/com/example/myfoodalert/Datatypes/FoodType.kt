package com.example.myfoodalert.Datatypes

import android.os.Parcel
import android.os.Parcelable
import com.example.myfoodalert.Activities.FoodGroupsActivity

data class FoodType(val name: String, val foodGroup: String = "",
               val roomTemperatureLife: String = "", val refrigetatorLife: String = "", val freezerLife: String = "") : Parcelable  {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
        dest?.writeString(foodGroup)
        dest?.writeString(roomTemperatureLife)
        dest?.writeString(refrigetatorLife)
        dest?.writeString(freezerLife)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<FoodType> {
        override fun createFromParcel(parcel: Parcel): FoodType {
            return FoodType(parcel)
        }

        override fun newArray(size: Int): Array<FoodType?> {
            return arrayOfNulls(size)
        }
    }

}
