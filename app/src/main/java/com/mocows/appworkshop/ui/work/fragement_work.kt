package com.mocows.appworkshop.ui.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.mocows.appworkshop.R
import java.util.concurrent.TimeUnit


class fragement_work : Fragment() {
    private lateinit var workViewModel: WorkViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        workViewModel =
            ViewModelProvider(this).get(WorkViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_work, container, false)





        return root


    }
}