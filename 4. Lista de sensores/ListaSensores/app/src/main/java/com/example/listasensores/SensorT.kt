package com.example.listasensores

import java.io.Serializable

class SensorT (
    val nombreSensor: String,
    val vendorSensor: String,
    val versionSensor: String,
    val imgSensor: Int
): Serializable
