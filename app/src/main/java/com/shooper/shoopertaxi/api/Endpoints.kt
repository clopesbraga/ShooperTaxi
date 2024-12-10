package com.shooper.shoopertaxi.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PATCH
import retrofit2.http.Path


interface Endpoints {

    companion object {
        private const val POST_RIDE_ESTIMATE = "ride/estimate"
        private const val PATCH_RIDE_CONFIRM = "ride/confirm"
        private const val GET_RIDE = "ride/{customer_id}?driver_id={id_do_motorista}"
    }

    @POST(POST_RIDE_ESTIMATE)
    suspend fun postEstimate(@Body car: String): Response<String>(): Response<>

    @PATCH(PATCH_RIDE_CONFIRM)
    suspend fun patchConfirm(@Body car: String): Response<String>

    @GET(GET_RIDE)
    suspend fun getRide(  @Path(value = "customer_id")customer_id :String,
                          @Path(value = "id_do_motorista") id_motorista:String
    ): Response<String>


}