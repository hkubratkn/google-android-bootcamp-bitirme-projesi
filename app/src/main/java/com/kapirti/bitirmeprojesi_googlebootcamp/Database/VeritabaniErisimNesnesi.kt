package com.kapirti.bitirmeprojesi_googlebootcamp.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import retrofit2.http.DELETE

@Dao
interface VeritabaniErisimNesnesi {
    @Insert
    fun insertAll(vararg saveData:SaveData)

    @Query("SELECT * FROM Harcamalar")
    fun getAllData():List<SaveData>

    @Query("SELECT * FROM Harcamalar WHERE dataId = :besinId")
    suspend fun getBesin(besinId : Int) : SaveData

    @DELETE
    fun delete(saveData: SaveData)

}