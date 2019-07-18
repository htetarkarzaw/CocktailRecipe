package com.htetarkarzaw.cocktailrecipe.data

import com.google.gson.annotations.SerializedName

class DrinkVO {
    @SerializedName("idDrink")
    var idDrink : Long = 0

    @SerializedName("strDrink")
    var strDrink : String? = null

    @SerializedName("strDrinkThumb")
    var strDrinkThumb : String? = null
}
