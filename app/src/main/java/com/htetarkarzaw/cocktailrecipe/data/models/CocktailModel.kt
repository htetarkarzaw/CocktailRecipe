package com.htetarkarzaw.cocktailrecipe.data.models

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.htetarkarzaw.cocktailrecipe.data.CocktailResponse
import com.htetarkarzaw.cocktailrecipe.data.DetailVO
import com.htetarkarzaw.cocktailrecipe.data.DrinkVO
import com.htetarkarzaw.cocktailrecipe.networks.ApiResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.RequestBody
import kotlin.Exception

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

    fun loadCocktail(
        type: String,
        mDrinkList: MutableLiveData<List<DrinkVO>>,
        errMsg: MutableLiveData<String>
    ): Disposable? {
        return mTheApi.loadCocktails(type)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> mDrinkList.value = result.getDrinkList() },
                { error -> errMsg.value = error.message })
    }

    fun loadTest(requestBodyText: String): Disposable? {
        var request =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><Request FN=\"LNC\" fromMember=\"09420159307\" PIN=\"0133\" osType=\"\" deviceToken=\"undefined\" updateDeviceToken=\"true\" lang=\"EN\" channel=\"mobileApp\" deviceModel=\"\" devicePlatform=\"\" deviceVersion=\"\" deviceManufacturer=\"\" packageName=\"\" versionNumber=\"\" isVirtualDevice=\"true\" geoLatitude=\"\" geoLongitude=\"\" appClientName=\"Myanmar\" appType=\"PRODUCTION\" deviceIP=\"\" uniqueDeviceKey=\"1560840679390\"></Request>"
        val requestBody = RequestBody.create(MediaType.parse("application/xml"), request)
        return mApiXml.getTest(requestBody)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> Log.e("Response", result.toString()) },
                { error -> Log.e("Response", error.message) })
    }


    fun loadCocktailByApiResponse(type: String, mResponse: MutableLiveData<ApiResponse<List<DrinkVO>>>): Disposable? {
        var apiResponse: ApiResponse<List<DrinkVO>> = ApiResponse()
        return mTheApi.loadCocktailByApiResponse(type)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                var body: CocktailResponse? = result.body()
                if (result.isSuccessful && body != null && body.getDrinkList().isNotEmpty()) {
                    apiResponse.data = body.getDrinkList()
                } else {
                    apiResponse.error = Exception(result.message())
                }
            }, { error ->
                apiResponse.error = error
            })
        mResponse.value = apiResponse
    }

    fun getCocktailById(
        cocktailId: Long,
        mDetailList: MutableLiveData<List<DetailVO>>,
        errMsg: MutableLiveData<String>
    ): Disposable? {
        return mTheApi.getCocktailDetails(cocktailId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> mDetailList.value = result.getDetailList() },
                { error -> errMsg.value = error.message })
    }
}