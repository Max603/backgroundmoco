package com.mocows.appworkshop.ui.Alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mocows.appworkshop.R
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

class AlarmFragment : Fragment() {



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_alarm, container, false)




        return root
    }
}


fun times(hour: Int, minute: Int): Long {   // get time difference From now to the set clock time
    var format = SimpleDateFormat("HH:mm:ss") //set the time format
    val t1 = format.parse("${hour}:${getDD(minute)}:00")    // format time
    val currentTime: String = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())  // get current time as String

    val t2 = format.parse(currentTime) //format current time


    return abs(t1.time - t2.time)   //return time difference
}

fun getDD(num: Int): String? {  // funtion format the time with a zero if the number has just one digit else just return num
    return if (num > 9) "" + num else "0$num"
}