package com.khalilayache.weatherapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup
import android.widget.TextView
import com.khalilayache.weatherapp.domain.model.ForecastList


class ForecastListAdapter (val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int = weekForecast.dailyForeCast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast.dailyForeCast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}