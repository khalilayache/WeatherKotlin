package com.khalilayache.weatherapp.domain.mappers

import com.khalilayache.weatherapp.data.Forecast
import com.khalilayache.weatherapp.data.ForecastResult
import com.khalilayache.weatherapp.domain.model.ForecastList
import com.khalilayache.weatherapp.domain.model.Forecast as ModelForecast
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit


class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList
    {
        return ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast>{

      return list.mapIndexed { i, forecast ->
          val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
          convertForecastListToDomain(forecast.copy(dt = dt))
      }
    }

    private fun convertForecastListToDomain(forecast: Forecast): ModelForecast{
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.getDefault())
        return df.format(date)
    }

    private fun generateIconUrl(iconCode: String) : String = "http://openweathermap.org/img/w/$iconCode.png"

}