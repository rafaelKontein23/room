package com.example.roomteste

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
data class Usuario(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val idade: Int
)


@Entity(primaryKeys = ["userId", "produtoId"]) // chave composta
data class Favorito(
    val userId: Int,
    val produtoId: Int,
    val dataFavorito: Long
)


