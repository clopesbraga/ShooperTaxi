package com.shooper.shoopertaxi.model.confirm

data class ConfirmModelRequest(
    val customer_id: String,
    val destination: String,
    val distance: String,
    val driver: Driver,
    val duration: String,
    val origin: String,
    val value: String
)

data class Driver(
    val id: String,
    val name: String
)