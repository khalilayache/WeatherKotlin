package com.khalilayache.weatherapp.domain.commands

interface Command<T> {

    fun execute(): T

}