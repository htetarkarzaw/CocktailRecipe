package com.htetarkarzaw.cocktailrecipe.networks

import com.htetarkarzaw.cocktailrecipe.data.CocktailDetailsResponse
import com.htetarkarzaw.cocktailrecipe.data.CocktailResponse
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface CocktailAPI {

    @POST("filter.php")
    fun loadCocktails(
        @Query("a") filter: String) : Observable<CocktailResponse>

    @POST("filter.php")
    fun loadCocktailByApiResponse(
        @Query("a") filter: String) : Observable<Response<CocktailResponse>>

    @POST("lookup.php")
    fun getCocktailDetails(
        @Query("i") cocktailId: Long): Observable<CocktailDetailsResponse>

    @Headers("Content-Type: application/xml")
    @POST("arttha")
    fun getTest(@Body body: RequestBody): Observable<com.example.myapplication.Response>

}