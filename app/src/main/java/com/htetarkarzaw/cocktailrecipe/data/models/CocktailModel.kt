package com.htetarkarzaw.cocktailrecipe.data.models

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.htetarkarzaw.cocktailrecipe.data.DetailVO
import com.htetarkarzaw.cocktailrecipe.data.DrinkVO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CocktailModel constructor(context: Context) : BaseModel(context) {
    companion object {
        private var INSTANCE: CocktailModel? = null
        fun getInstance(): CocktailModel {
            if (INSTANCE == null) {
                throw RuntimeException("CocktailModel is being invoked before initializing.")
            }
            val i = INSTANCE
            return i!!
        }

        fun initHealthCareModel(context: Context) {
            INSTANCE =
                CocktailModel(context)
        }
    }

    fun loadCocktail(type:String,mDrinkList: MutableLiveData<List<DrinkVO>>, errMsg: MutableLiveData<String>): Disposable? {
       return mTheApi.loadCocktails(type)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> mDrinkList.value = result.getDrinkList()},
                { error -> errMsg.value = error.message })
    }

    fun getCocktailById(cocktailId:Long, mDetailList: MutableLiveData<List<DetailVO>>, errMsg: MutableLiveData<String>): Disposable? {
        return mTheApi.getCocktailDetails(cocktailId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> mDetailList.value = result.getDetailList()},
                { error -> errMsg.value = error.message })
    }
}