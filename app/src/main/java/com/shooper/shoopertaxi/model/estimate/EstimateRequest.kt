package com.shooper.shoopertaxi.model.estimate

data class EstimateRequest(
    val customer_id: String,
    val destination: String,
    val origin: String
)