package com.mocows.appworkshop.ui.work

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.mocows.appworkshop.R

class WorkOneTimeRequest (context: Context, workerParams: WorkerParameters) : Worker(context,workerParams){
    companion object{
        private const val WORK_MANAGER_PERIODIC_CHANNEL_ID= "CHANNEL_ID_WORK_MANAGER_PERIODICAL"
        private const val WORK_MANAGER_PERIODICAL_CHANNEL_NAME="WORK_MANAGER_PERIODICAL"
        /**
         * TODO: Einfügen der Variablen für die Tage in Quarantäne und einem Counter für den Durchlauf
         */
    }
    override fun doWork(): Result {
        /**
         * TODO: Erstellen der Notification für den Qurantänestatus
         */
        return Result.success()
    }
    fun createNotification(title:String,description:String) {

        var notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(WORK_MANAGER_PERIODIC_CHANNEL_ID, WORK_MANAGER_PERIODICAL_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        val notificationBuilder = NotificationCompat.Builder(applicationContext, WORK_MANAGER_PERIODIC_CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(description)
            .setSmallIcon(R.drawable.ic_menu_work)

        notificationManager.notify(2, notificationBuilder.build())
    }
}