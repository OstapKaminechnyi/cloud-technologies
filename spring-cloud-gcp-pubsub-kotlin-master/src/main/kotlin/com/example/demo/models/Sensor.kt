package com.example.demo.models

import java.io.Serializable


data class Sensor(val name: String,
                  val type: String,
                  val date: String,
                  val time: String,
                  val lat: Float,
                  val lng: Float,
                  val measurement: String) : Serializable