package com.mocows.appworkshop.ui.Alarm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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


fun times(hour: Int, minute: Int): Long {
    var format = SimpleDateFormat("HH:mm:ss")
    val t1 = format.parse("${hour}:${getDD(minute)}:00")
    val currentTime: String = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
    val t2 = format.parse(currentTime)


    var diff = abs(t1.time - t2.time)

    val s = (diff / 1000)
    return s
}

fun getDD(num: Int): String? {
    return if (num > 9) "" + num else "0$num"
}