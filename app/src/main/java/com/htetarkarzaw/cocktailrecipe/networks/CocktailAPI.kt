package com.htetarkarzaw.cocktailrecipe.networks

import com.htetarkarzaw.cocktailrecipe.data.CocktailDetailsResponse
import com.htetarkarzaw.cocktailrecipe.data.CocktailResponse
import io.reactivex.Observable
import retrofit2.http.*

interface CocktailAPI {

    @POST("filter.php")
    fun loadCocktails(
        @Query("a") filter: String) : Observable<CocktailResponse>

    @POST("lookup.php")
    fun getCocktailDetails(
        @Query("i") cocktailId: Long): Observable<CocktailDetailsResponse>
}