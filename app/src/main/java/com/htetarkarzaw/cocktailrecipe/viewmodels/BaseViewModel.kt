package com.htetarkarzaw.cocktailrecipe.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.htetarkarzaw.cocktailrecipe.data.DrinkVO
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {
    protected var errorLD: MutableLiveData<String>? = null
    protected lateinit var compositeDisposable: CompositeDisposable

    init {
        errorLD = MutableLiveData()
        compositeDisposable = CompositeDisposable()
    }

    fun getError(): LiveData<String> {
        return this.errorLD!!
    }

    override fun onCleared() {
        super.onCleared()
        if(!compositeDisposable.isDisposed){
            compositeDisposable.dispose()
        }
    }
}