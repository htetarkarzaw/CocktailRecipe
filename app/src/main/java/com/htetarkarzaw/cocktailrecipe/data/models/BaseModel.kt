package com.htetarkarzaw.cocktailrecipe.data.models

import android.content.Context
import com.google.gson.Gson
import com.htetarkarzaw.cocktailrecipe.utils.AppConstants
import com.htetarkarzaw.cocktailrecipe.networks.CocktailAPI
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel protected constructor(context: Context) {

    protected var mTheApi: CocktailAPI
    protected var mApiXml: CocktailAPI
    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        val retrofitXML = Retrofit.Builder()
            .baseUrl("http://203.81.78.180:9080/")
            .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(Persister(AnnotationStrategy())))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        val retrofitN = Retrofit.Builder()
            .baseUrl("http://203.81.78.180:9080/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
        mTheApi = retrofit.create(CocktailAPI::class.java)
        mApiXml = retrofitXML.create(CocktailAPI::class.java)
    }
}