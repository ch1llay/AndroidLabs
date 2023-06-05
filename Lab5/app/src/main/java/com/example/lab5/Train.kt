package com.example.lab5

import java.time.LocalTime

data class Train(
    val arrivedPlace: String,
    val derivedPlace: String,
    val arrivedTime: LocalTime,
    val derivedTime: LocalTime
)