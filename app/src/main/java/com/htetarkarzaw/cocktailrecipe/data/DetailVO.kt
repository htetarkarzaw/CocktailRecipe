package com.htetarkarzaw.cocktailrecipe.data

import com.google.gson.annotations.SerializedName

class DetailVO(
    @SerializedName("idDrink")
    var idDrink: Long = 0,

    @SerializedName("strDrink")
    var strDrink: String? = null,

    @SerializedName("strTags")
    var strTags: String? = null,

    @SerializedName("strCategory")
    var strCategory: String? = null,

    @SerializedName("strIBA")
    var strIBA: String? = null,

    @SerializedName("strAlcoholic")
    var strAlcoholic: String? = null,

    @SerializedName("strGlass")
    var strGlass: String? = null,

    @SerializedName("strInstructions")
    var strInstructions: String? = null,

    @SerializedName("strDrinkThumb")
    var strDrinkThumb: String? = null,

    @SerializedName("strIngredient1")
    var strIngredient1: String? = null,

    @SerializedName("strIngredient2")
    var strIngredient2: String? = null,

    @SerializedName("strIngredient3")
    var strIngredient3: String? = null,

    @SerializedName("strIngredient4")
    var strIngredient4: String? = null,

    @SerializedName("strIngredient5")
    var strIngredient5: String? = null,

    @SerializedName("strIngredient6")
    var strIngredient6: String? = null,

    @SerializedName("strIngredient7")
    var strIngredient7: String? = null,

    @SerializedName("strIngredient8")
    var strIngredient8: String? = null,

    @SerializedName("strIngredient9")
    var strIngredient9: String? = null,

    @SerializedName("strIngredient10")
    var strIngredient10: String? = null,

    @SerializedName("strIngredient11")
    var strIngredient11: String? = null,

    @SerializedName("strIngredient12")
    var strIngredient12: String? = null,

    @SerializedName("strIngredient13")
    var strIngredient13: String? = null,

    @SerializedName("strIngredient14")
    var strIngredient14: String? = null,

    @SerializedName("strIngredient15")
    var strIngredient15: String? = null,

    @SerializedName("strMeasure1")
    var strMeasure1: String? = null,

    @SerializedName("strMeasure2")
    var strMeasure2: String? = null,

    @SerializedName("strMeasure3")
    var strMeasure3: String? = null,

    @SerializedName("strMeasure4")
    var strMeasure4: String? = null,

    @SerializedName("strMeasure5")
    var strMeasure5: String? = null,

    @SerializedName("strMeasure6")
    var strMeasure6: String? = null,

    @SerializedName("strMeasure7")
    var strMeasure7: String? = null,

    @SerializedName("strMeasure8")
    var strMeasure8: String? = null,

    @SerializedName("strMeasure9")
    var strMeasure9: String? = null,

    @SerializedName("strMeasure10")
    var strMeasure10: String? = null,

    @SerializedName("strMeasure11")
    var strMeasure11: String? = null,

    @SerializedName("strMeasure12")
    var strMeasure12: String? = null,

    @SerializedName("strMeasure13")
    var strMeasure13: String? = null,

    @SerializedName("strMeasure14")
    var strMeasure14: String? = null,

    @SerializedName("strMeasure15")
    var strMeasure15: String? = null,

    @SerializedName("strCreativeCommonsConfirmed")
    var strCreativeCommonsConfirmed: Boolean? = true,

    @SerializedName("dateModified")
    var dateModified: String? = null

){
    fun getIngredientList(): List<IngredientVO>{
        val listVal = ArrayList<IngredientVO>()
        if(!strIngredient1.equals("")){
            val ingredientVO = IngredientVO(strIngredient1, strMeasure1)
            listVal.add(ingredientVO)
        }else return listVal
        if(!strIngredient2.equals("")){
            val ingredientVO = IngredientVO(strIngredient2, strMeasure2)
            listVal.add(ingredientVO)
        }else return listVal
        if(!strIngredient3.equals("")){
            val ingredientVO = IngredientVO(strIngredient3, strMeasure3)
            listVal.add(ingredientVO)
        }else return listVal
        if(!strIngredient4.equals("")){
            val ingredientVO = IngredientVO(strIngredient4, strMeasure4)
            listVal.add(ingredientVO)
        }else return listVal
        if(!strIngredient5.equals("")){
            val ingredientVO = IngredientVO(strIngredient5, strMeasure5)
            listVal.add(ingredientVO)
        }else return listVal
        if(!strIngredient6.equals("")){
            val ingredientVO = IngredientVO(strIngredient6, strMeasure6)
            listVal.add(ingredientVO)
        }else return listVal
        if(!strIngredient7.equals("")){
            val ingredientVO = IngredientVO(strIngredient7, strMeasure7)
            listVal.add(ingredientVO)
        }else return listVal
        if(!strIngredient8.equals("")){
            val ingredientVO = IngredientVO(strIngredient8, strMeasure8)
            listVal.add(ingredientVO)
        }else return listVal
        if(!strIngredient9.equals("")){
            val ingredientVO = IngredientVO(strIngredient9, strMeasure9)
            listVal.add(ingredientVO)
        }else return listVal
        if(!strIngredient10.equals("")){
            val ingredientVO = IngredientVO(strIngredient10, strMeasure10)
            listVal.add(ingredientVO)
        }else return listVal
        if(!strIngredient11.equals("")){
            val ingredientVO = IngredientVO(strIngredient11, strMeasure11)
            listVal.add(ingredientVO)
        }else return listVal
        if(!strIngredient12.equals("")){
            val ingredientVO = IngredientVO(strIngredient12, strMeasure12)
            listVal.add(ingredientVO)
        }else return listVal
        if(!strIngredient13.equals("")){
            val ingredientVO = IngredientVO(strIngredient13, strMeasure13)
            listVal.add(ingredientVO)
        }else return listVal
        if(!strIngredient14.equals("")){
            val ingredientVO = IngredientVO(strIngredient14, strMeasure14)
            listVal.add(ingredientVO)
        }else return listVal
        if(!strIngredient15.equals("")){
            val ingredientVO = IngredientVO(strIngredient15, strMeasure15)
            listVal.add(ingredientVO)
        }else return listVal

        return listVal
    }
}
