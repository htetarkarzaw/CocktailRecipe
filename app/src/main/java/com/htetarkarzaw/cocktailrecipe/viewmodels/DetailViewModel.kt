package com.htetarkarzaw.cocktailrecipe.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.htetarkarzaw.cocktailrecipe.data.DetailVO
import com.htetarkarzaw.cocktailrecipe.data.DrinkVO
import com.htetarkarzaw.cocktailrecipe.data.models.CocktailModel

class DetailViewModel: BaseViewModel() {
    private var mDetailVOS: MutableLiveData<List<DetailVO>>? = null
    init {
        mDetailVOS=MutableLiveData<List<DetailVO>>()
    }

    fun loadDetails(cocktailId:Long){
        CocktailModel.getInstance().getCocktailById(cocktailId,mDetailVOS!!,errorLD!!)?.let { compositeDisposable.add(it) }
    }

    fun getDetails(): LiveData<List<DetailVO>> {
        return this.mDetailVOS!!
    }


}