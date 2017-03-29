package com.khalilayache.weatherapp.domain.commands

/**
 * Created by USUARIO
on 28/03/2017.
 */
interface Command<T> {

    fun execute(): T

}