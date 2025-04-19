package com.example.roomteste.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomteste.Usuario

@Dao
interface UsuarioDao {

    // INSERT
    @Insert
    suspend fun inserir(usuario: Usuario)

    // UPDATE
    @Update
    suspend fun atualizar(usuario: Usuario)

    // DELETE
    @Delete
    suspend fun deletar(usuario: Usuario)

    // SELECT - listar todos
    @Query("SELECT * FROM usuario")
    suspend fun listarTodos(): List<Usuario>

    // SELECT com filtro
    @Query("SELECT * FROM usuario WHERE nome LIKE :nome")
    suspend fun buscarPorNome(nome: String): List<Usuario>
}