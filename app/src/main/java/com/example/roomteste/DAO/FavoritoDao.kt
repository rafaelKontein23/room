package com.example.roomteste.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.roomteste.Favorito

@Dao
interface FavoritoDao {

    @Insert
    suspend fun inserir(favorito: Favorito)

    @Query("SELECT * FROM Favorito WHERE userId = :userId")
    suspend fun buscarFavoritosDoUsuario(userId: Int): List<Favorito>

    @Delete
    suspend fun deletar(favorito: Favorito)
}