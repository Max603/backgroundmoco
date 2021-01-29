package com.mocows.appworkshop.ui.Alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.widget.Toast
import com.mocows.appworkshop.R

class Alarm : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
            val mp = MediaPlayer.create(context, R.raw.beep)
            mp.start()
            Toast.makeText(context,"Alarm",Toast.LENGTH_SHORT).show()
    }


}