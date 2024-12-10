package com.shooper.shoopertaxi.model.estimate

data class EstimateModelResponse(
    val destination: Destination,
    val distance: Int,
    val duration: Int,
    val options: List<Any>,
    val origin: Origin,
//    val routeResponse: RouteResponse
)


data class Destination(
    val latitude: Int,
    val longitude: Int
)

data class Origin(
    val latitude: Int,
    val longitude: Int
)

//data class RouteResponse()