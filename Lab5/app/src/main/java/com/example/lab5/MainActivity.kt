package com.example.lab5

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalTime

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<RecyclerView>(R.id.trainList)

        val list = mutableListOf<Train>()
        val listAdapter = TrainsAdapter(list) {
            Toast.makeText(
                this,
                "Нажат поезд ${it.arrivedPlace} ${it.derivedPlace}",
                Toast.LENGTH_SHORT
            ).show()
        }



        listAdapter.trains += Train(
            "Москва",
            "Казань",
            LocalTime.parse("10:10:10"),
            LocalTime.parse("12:10:10")
        )

        listAdapter.trains += Train(
            "Пенза",
            "Сочи",
            LocalTime.parse("10:10:10"),
            LocalTime.parse("12:10:10")
        )

        listView.adapter = listAdapter
        listView.layoutManager = LinearLayoutManager(this)


        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            listAdapter.trains += Train(
                "СПБ",
                "Новосиб",
                LocalTime.parse("12:10:10"),
                LocalTime.parse("12:10:10")
            )
            listAdapter.notifyItemInserted(listAdapter.itemCount - 1)
            Toast.makeText(
                this,
                "Нажата кнопка",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}