package com.kapirti.bitirmeprojesi_googlebootcamp.Service

import com.kapirti.bitirmeprojesi_googlebootcamp.Model.CurrencyModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MoneyApiServise {

    //GET https://api.ratesapi.io/api/latest HTTP/2
    //BASE = GET https://api.ratesapi.io/
    //left = api/latest HTTP/2

    private val BASE_URL="https://api.ratesapi.io/"
    private val api=Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MoneyApi::class.java)

    fun getData():Single<List<CurrencyModel>>{
        return api.getApi()
    }

}