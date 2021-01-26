package com.mocows.appworkshop.ui.services

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.mocows.appworkshop.R
import android.content.Intent
import androidx.core.content.ContextCompat


class MyServicesFragment : Fragment() {
    private lateinit var myservicesViewModel: MyServicesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myservicesViewModel =
            ViewModelProvider(this).get(MyServicesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_my_services, container, false)
        val conbtn= root.findViewById<Button>(R.id.myservice_connection_button)
        conbtn.setOnClickListener() {

            /**
             * TODO: Erstellung eines Intents und Starten des Forground Services und Background Service
             **/
        }


        return root
    }
}