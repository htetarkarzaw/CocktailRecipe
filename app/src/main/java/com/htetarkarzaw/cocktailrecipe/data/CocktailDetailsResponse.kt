package com.htetarkarzaw.cocktailrecipe.data

import com.google.gson.annotations.SerializedName

class CocktailDetailsResponse(
    @SerializedName("drinks")
    private var drinkList: List<DetailVO>? = null
) {
    fun getDetailList(): List<DetailVO> {
        if (drinkList == null) drinkList = ArrayList<DetailVO>()
        val listVal = drinkList
        return listVal!!
    }
}
