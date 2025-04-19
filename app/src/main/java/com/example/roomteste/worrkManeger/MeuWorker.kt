package com.example.roomteste.worrkManeger
import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast

class MeuWorker(
    appContext: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        Log.d("MeuWorker", "Executando trabalho em segundo plano")

        // Mostrar um Toast (precisa de Looper no background thread)
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(applicationContext, "Executando trabalho", Toast.LENGTH_SHORT).show()
        }

        return Result.success() // ou Result.retry() ou Result.failure()
    }
}