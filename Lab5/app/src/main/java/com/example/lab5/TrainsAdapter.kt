package com.example.lab5;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TrainsAdapter(val trains: MutableList<Train>, private val onClick: (Train) -> Unit) :
    RecyclerView.Adapter<TrainsAdapter.ViewHolder>() {

    class ViewHolder(view: View, private val onClick: (Train) -> Unit) :
        RecyclerView.ViewHolder(view) {

        private val arrivedPlaceView: TextView = view.findViewById(R.id.arrivedPlaceText)
        private val derivedPlaceView: TextView = view.findViewById(R.id.derivedPlaceText)
        private val arrivedTimeView: TextView = view.findViewById(R.id.arrivedTimeText)
        private val derivedTimeView: TextView = view.findViewById(R.id.derivedTimeText)

        private lateinit var train: Train

        init {
            view.setOnClickListener {
                onClick(train)
            }
        }

        fun bind(train: Train) {
            this.train = train
            arrivedPlaceView.text = train.arrivedPlace
            derivedPlaceView.text = train.derivedPlace
            arrivedTimeView.text = train.arrivedTime.toString()
            derivedTimeView.text = train.derivedTime.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.train_item_layout, parent, false)

        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(trains[position])
    }

    override fun getItemCount() = trains.size
}