package com.example.roomteste.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomteste.DAO.FavoritoDao
import com.example.roomteste.DAO.UsuarioDao
import com.example.roomteste.Favorito
import com.example.roomteste.Usuario

@Database(entities = [Usuario::class, Favorito::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
    abstract fun favoritoDao(): FavoritoDao

}