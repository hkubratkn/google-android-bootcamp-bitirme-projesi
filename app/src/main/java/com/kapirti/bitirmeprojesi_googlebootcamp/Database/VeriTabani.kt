package com.kapirti.bitirmeprojesi_googlebootcamp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(SaveData::class),version = 1)
abstract class VeriTabani : RoomDatabase() {

    abstract fun veritabaniErisimNesnesi():VeritabaniErisimNesnesi

    //Singleton

    companion object {

        @Volatile private var instance : VeriTabani? = null

        private val lock = Any()

        operator fun invoke(context : Context) = instance ?: synchronized(lock){
            instance ?: databaseOlustur(context).also {it->
                instance = it
            }
        }


        private fun databaseOlustur(context: Context) = Room.databaseBuilder(
                context.applicationContext,
                VeriTabani::class.java,"besindatabase").build()

    }

}