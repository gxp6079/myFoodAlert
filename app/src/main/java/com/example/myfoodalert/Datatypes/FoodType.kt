package com.example.myfoodalert.Datatypes

import android.os.Parcel
import android.os.Parcelable
import com.example.myfoodalert.Activities.FoodGroupsActivity

class FoodType(val name: String, val foodGroup: FoodGroupsActivity.FoodGroup,
               val roomTemperatureLife: String = "", val refrigetatorLife: String = "", val freezerLife: String = "") : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            TODO("foodGroup"),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(roomTemperatureLife)
        parcel.writeString(refrigetatorLife)
        parcel.writeString(freezerLife)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FoodType> {
        override fun createFromParcel(parcel: Parcel): FoodType {
            return FoodType(parcel)
        }

        override fun newArray(size: Int): Array<FoodType?> {
            return arrayOfNulls(size)
        }
    }
}
