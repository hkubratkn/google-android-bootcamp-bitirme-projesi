package com.kapirti.bitirmeprojesi_googlebootcamp.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Harcamalar")
data class SaveData(
    @ColumnInfo(name = "yazisi")
    val yazisi:String,
    @ColumnInfo(name="fiyati")
    val fiyati:String,
    @ColumnInfo(name = "paraTuru")
    val paraTuru:Int,
    @ColumnInfo(name = "resmi")
    val resmi:Int
    ){
    @PrimaryKey(autoGenerate = true)
    val dataId:Int=0
}