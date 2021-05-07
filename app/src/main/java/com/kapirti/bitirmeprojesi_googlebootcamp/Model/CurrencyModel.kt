package com.kapirti.bitirmeprojesi_googlebootcamp.Model

import com.google.gson.annotations.SerializedName

data class CurrencyModel (
        @SerializedName("EUR")
        val euro:Double?,
        @SerializedName("USD")
        val dolar:Double?,
        @SerializedName("TRY")
        val lira:Double,
        @SerializedName("GBP")
        val sterlin:Double?){
}