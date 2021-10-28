package com.fourohtwo.shopshop.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fourohtwo.shopshop.data.model.Perso

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters")
    fun getAllCharacters() : LiveData<List<Perso>>

    @Query("SELECT * FROM characters WHERE id = :id")
    fun getCharacter(id: Int): LiveData<Perso>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(persos: List<Perso>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(perso: Perso)


}