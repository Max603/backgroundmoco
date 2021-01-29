package com.mocows.appworkshop.ui.Thread

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

import com.mocows.appworkshop.R
import org.json.JSONObject
import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL


class ThreadFragment : Fragment() {
 
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_thread, container, false)

        val connect = root.findViewById<Button>(R.id.connect)
        val autotext = root.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val info = root.findViewById<TextView>(R.id.infos)
        var location : MutableList<String> = mutableListOf()

        Thread {
            var reque = URL("https://services7.arcgis.com/mOBPykOjAyBO2ZKk/arcgis/rest/services/RKI_Landkreisdaten/FeatureServer/0/query?where=1=1&outFields=GEN&returnGeometry=false&f=json") //request url
            val conn: HttpURLConnection = reque.openConnection() as HttpURLConnection // create a connection
            val data = conn.inputStream.bufferedReader().use(BufferedReader::readText) //read recevied bytes from request


            //loop at all objects in features
            val field = JSONObject(data).getJSONArray("features") // get object features in json
            for (i in 0..(field.length()-1)) {
                val attr = field.getJSONObject(i)   // get object of features at position i
                val ele = attr.getJSONObject("attributes") // get attribute of object
                val cases = ele.getString("GEN")    // get Gen .... Gen has the location Name
                location.add(cases)    //add location name to list
            }
            //do actions
        }.start()

        val ad : ArrayAdapter<String> = ArrayAdapter(root.context,R.layout.support_simple_spinner_dropdown_item,location);
        autotext.setAdapter(ad)

        connect.setOnClickListener {
            Thread {
                var reque = URL("https://services7.arcgis.com/mOBPykOjAyBO2ZKk/arcgis/rest/services/RKI_Landkreisdaten/FeatureServer/0/query?where=GEN='${autotext.text}'&outFields=cases7_per_100k_txt&returnGeometry=false&f=json") //create url for location in autotext

                val conn: HttpURLConnection = reque.openConnection() as HttpURLConnection //connect to url

                val json = conn.inputStream.bufferedReader().use(BufferedReader::readText) //read response
                val field = JSONObject(json).getJSONArray("features")       // get feature object
                val attr = field.getJSONObject(0)       //only one feature so no loop needed
                val ele = attr.getJSONObject("attributes")  // get attributes of object
                val cases = ele.getString("cases7_per_100k_txt") // get cases
                this.activity?.runOnUiThread() {
                    //does actions on Ui-Thread u neeed it because Ui-elements can only be edited in Main/Ui-Thread
                    info.text = "$cases Fälle pro 100 000 Einwohner in den letzten 7 tagen"
                }
            }.start()
        }
        return root
    }
}