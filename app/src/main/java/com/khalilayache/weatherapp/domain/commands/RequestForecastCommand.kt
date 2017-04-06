package com.khalilayache.weatherapp.domain.commands

import com.khalilayache.weatherapp.data.ForecastRequest
import com.khalilayache.weatherapp.domain.mappers.ForecastDataMapper
import com.khalilayache.weatherapp.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: String): Command<ForecastList>{

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}