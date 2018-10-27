package com.prekshashukla.drinkwater.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.prekshashukla.drinkwater.utility.NotificationUtils
import com.prekshashukla.drinkwater.R
import java.util.*

/**
 * Created by PrekshaShukla
 * This is main activity.
 */

class MainActivity : AppCompatActivity() {

    private val mNotificationTime = Calendar.getInstance().timeInMillis + 360000 //Set after 1hr from the current time.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

                NotificationUtils().setNotification(mNotificationTime, this@MainActivity)
    }
}