package com.htetarkarzaw.cocktailrecipe

import android.app.Application
import com.htetarkarzaw.cocktailrecipe.data.models.CocktailModel

class CocktailApp: Application() {
    companion object {
        const val TAG ="CocktailRecipeApp"
    }

    override fun onCreate() {
        super.onCreate()
        CocktailModel.initHealthCareModel(applicationContext)
    }
}