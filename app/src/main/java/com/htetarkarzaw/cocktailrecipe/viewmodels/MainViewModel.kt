package com.htetarkarzaw.cocktailrecipe.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.htetarkarzaw.cocktailrecipe.data.DrinkVO
import com.htetarkarzaw.cocktailrecipe.data.models.CocktailModel

class MainViewModel: BaseViewModel() {
    private var mCocktailVOS: MutableLiveData<List<DrinkVO>>? = null
    init {
        mCocktailVOS=MutableLiveData()
//        loadTest()
    }

    fun loadCocktails(type:String){
        CocktailModel.getInstance().loadCocktail(type,mCocktailVOS!!,errorLD!!)?.let { compositeDisposable.add(it) }
    }

    fun loadTest(request:String){
        CocktailModel.getInstance().loadTest(request)
    }

    fun getCocktails(): LiveData<List<DrinkVO>> {
        return this.mCocktailVOS!!
    }


}