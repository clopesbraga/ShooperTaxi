package com.shooper.shoopertaxi.api

import com.shooper.shoopertaxi.model.confirm.ConfirmModelResponse
import com.shooper.shoopertaxi.model.confirm.Driver
import com.shooper.shoopertaxi.model.estimate.EstimateModelResponse
import com.shooper.shoopertaxi.model.ride.RideModelResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PATCH
import retrofit2.http.Path


interface Endpoints {

    companion object {
        private const val POST_RIDE_ESTIMATE = "/ride/estimate"
        private const val PATCH_RIDE_CONFIRM = "/ride/confirm"
        private const val GET_RIDE = "/ride/{customer_id}?driver_id={id_do_motorista}"
    }

    @POST(POST_RIDE_ESTIMATE)
    suspend fun postEstimate(
        @Body customer_id: String,
        @Body origin: String,
        @Body destination: String

    ): Response<EstimateModelResponse>

    @PATCH(PATCH_RIDE_CONFIRM)
    suspend fun patchConfirm(
        @Body customer_id: String,
        @Body destination: String,
        @Body distance: String,
        @Body driver: Driver,
        @Body duration: String,
        @Body origin: String,
    ): Response<ConfirmModelResponse>

    @GET(GET_RIDE)
    suspend fun getRide(
        @Path(value = "customer_id")customer_id :String,
        @Path(value = "id_do_motorista") id_motorista:String
    ): Response<RideModelResponse>


}