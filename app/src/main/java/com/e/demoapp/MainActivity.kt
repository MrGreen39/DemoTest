package com.e.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.youpic.adapter.DataAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var jsonString="{\n" +
                "   \"history\":[\n" +
                "      {\n" +
                "         \"name\":\"USA\",\n" +
                "         \"grandfathers\":[\n" +
                "            {\n" +
                "               \"gFName\":\"Steve\",\n" +
                "               \"grandfathersKid\":[\n" +
                "                  {\n" +
                "                     \"gFKName\":\"Linda\",\n" +
                "                     \"kid\":[\n" +
                "                        {\n" +
                "                           \"name\":\"Steve JR\",\n" +
                "                           \"friends\":[\n" +
                "                              {\n" +
                "                                 \"name\":\"Kriss|John|Martin|Steven\"\n" +
                "                              }\n" +
                "                           ]\n" +
                "                        }\n" +
                "                     ]\n" +
                "                  }\n" +
                "               ]\n" +
                "            }\n" +
                "         ]\n" +
                "      }\n" +
                "   ]\n" +
                "}"

        val data=Gson().fromJson(jsonString,JsonDataModel::class.java)


        rcView.layoutManager=LinearLayoutManager(this)
        rcView.adapter= DataAdapter(this,data.history!!)
    }
}