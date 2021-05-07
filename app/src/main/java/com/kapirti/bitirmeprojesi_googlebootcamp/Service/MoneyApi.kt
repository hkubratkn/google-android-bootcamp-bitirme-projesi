package com.kapirti.bitirmeprojesi_googlebootcamp.Service

import com.kapirti.bitirmeprojesi_googlebootcamp.Model.CurrencyModel
import io.reactivex.Single
import retrofit2.http.GET

interface MoneyApi {

    //GET https://api.ratesapi.io/api/latest HTTP/2
    //BASE = GET https://api.ratesapi.io/
    //left = api/latest HTTP/2
    @GET("api/latest")
    fun getApi(): Single<List<CurrencyModel>>
}