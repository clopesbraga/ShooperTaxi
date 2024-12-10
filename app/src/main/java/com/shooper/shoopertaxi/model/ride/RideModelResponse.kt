package com.shooper.shoopertaxi.model.ride

data class RideModelResponse(
    val customer_id: String,
    val rides: List<Ride>
)

data class Ride(
    val date: String,
    val destination: String,
    val distance: String,
    val driver: Driver,
    val duration: String,
    val id: String,
    val origin: String,
    val value: String
)


data class Driver(
    val id: String,
    val name: String
)