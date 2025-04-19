package com.example.roomteste

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.roomteste.config.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.roomteste.worrkManeger.MeuWorker


class MainActivity : AppCompatActivity() {

    lateinit var  btninserir : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()

        val usuarioDao = db.usuarioDao()

        btninserir = findViewById(R.id.btninserir)

        agendarTrabalho()
        btninserir.setOnClickListener {
            val usaurio = Usuario(nome = "Fael", idade = 20)

            CoroutineScope(Dispatchers.IO).launch {
                usuarioDao.inserir(usaurio)

                val usuarios = usuarioDao.listarTodos()
                usuarios.forEach {
                    println(it)
                }
            }

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    // aqui é do work manager ondee eu vou agendar a tarefa
    private fun agendarTrabalho() {
        val workRequest = OneTimeWorkRequestBuilder<MeuWorker>()
            .build()

        WorkManager.getInstance(this).enqueue(workRequest)
    }
}