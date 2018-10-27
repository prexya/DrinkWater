package com.prekshashukla.drinkwater.utility

import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import com.prekshashukla.drinkwater.service.AlarmReceiver
import java.util.*

/**
 * Created by PrekshaShukla
 * for alarm setting repeating every hour.
 */

class NotificationUtils {


    fun setNotification(timeInMilliSeconds: Long, activity: Activity) {

        if (timeInMilliSeconds > 0) {


            val alarmManager = activity.getSystemService(Activity.ALARM_SERVICE) as AlarmManager
            val alarmIntent = Intent(activity.applicationContext, AlarmReceiver::class.java)

            alarmIntent.putExtra("reason", "notification")
            alarmIntent.putExtra("timestamp", timeInMilliSeconds)



            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timeInMilliSeconds


            val pendingIntent = PendingIntent.getBroadcast(activity, 0, alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT)
            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis ,
                AlarmManager.INTERVAL_HOUR,
                pendingIntent)

        }

    }
}