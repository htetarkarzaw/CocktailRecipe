package com.htetarkarzaw.cocktailrecipe.data

import com.google.gson.annotations.SerializedName

class CocktailResponse {

    @SerializedName("drinks")
    private var drinkList: List<DrinkVO>? = null

    fun getDrinkList(): List<DrinkVO>{
        if (drinkList == null) drinkList = ArrayList<DrinkVO>()
        val listVal = drinkList
        return listVal!!
    }
}