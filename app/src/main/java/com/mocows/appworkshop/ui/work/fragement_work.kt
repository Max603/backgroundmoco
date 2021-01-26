package com.mocows.appworkshop.ui.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mocows.appworkshop.R


class fragement_work : Fragment() {
    companion object{
        /**
         * TODO: Erstellung einer lateinit Variable um den WorkManager aus einer anderen Klasse beenden zu können
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
         * TODO: Erstellen der Aufgaben für den Periodischen und den Einmaligen Aufruf des WorkManagers
         */
        val btnonetime =root.findViewById<Button>(R.id.work_manager_button)
        val cancelbutton =root.findViewById<Button>(R.id.work_manager_button)
        btnonetime.setOnClickListener {
            /**
             * TODO: Erstellen der Instanzen für den Periodischen und den Einmaligen Aufruf des WorkManagers
             */
        }

        cancelbutton.setOnClickListener {
            /**
             * TODO: Erstellen der WorkManager Cancel Methode
             */
        }


        return root


    }
}