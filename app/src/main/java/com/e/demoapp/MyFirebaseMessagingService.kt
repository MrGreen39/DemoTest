package com.youpic.firebase

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ContentResolver
import android.content.Intent
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.e.demoapp.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        val msgMap = remoteMessage.data
        Log.w("testNotification", remoteMessage.data.toString())
        sendNotification((if (msgMap["title"] == null) "DemoApp" else msgMap["title"])!!,
                msgMap["body"])
    }

    override fun onNewToken(s: String) {
        super.onNewToken(s)
    }

    override fun onDeletedMessages() {
        super.onDeletedMessages()
    }

    private fun sendNotification(title: String, messageBody: String?)
    {

        var intent: Intent
        intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK)

        val pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT)
        val channelId = "youpick_noti"
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
                .setContentTitle(title + "")
                .setContentText(messageBody + "")
                .setAutoCancel(true)
                .setVibrate(LongArray(0))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_VIBRATE)
                .setContentIntent(pendingIntent)
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(channelId,
                    "Notification",
                    NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.enableVibration(true)
            channel.vibrationPattern = LongArray(0)
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(430, notificationBuilder.build())
    }



}