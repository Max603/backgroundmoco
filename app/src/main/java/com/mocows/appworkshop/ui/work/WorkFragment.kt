package com.mocows.appworkshop.ui.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.mocows.appworkshop.R
import java.util.concurrent.TimeUnit


class WorkFragment : Fragment() {
    companion object{
        /**
         * TODO: Erstellen einer lateint Variable
         */

    }
    private lateinit var workViewModel: WorkViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        workViewModel =
            ViewModelProvider(this).get(WorkViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_work, container, false)


        /**
         *TODO: Erstellen der Requests für den OneTimeWorker und Periodical Worker
         */

        /**
         * TODO: Erstellen der WorkManager Instanz
         */

        val btnonetime =root.findViewById<Button>(R.id.work_manager_button)
        val cancelbutton =root.findViewById<Button>(R.id.workmanagercancel_button)
        btnonetime.setOnClickListener {
            /**
             * TODO: Requests in die Warteschlange hinzufügen
             */
        }

        cancelbutton.setOnClickListener {
            /**
             * TODO: Beenden des Periodischen Events
             */
        }


        return root


    }
}