package com.shooper.shoopertaxi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.shooper.shoopertaxi.api.Endpoints
import com.shooper.shoopertaxi.api.ShooperApi
import kotlinx.coroutines.launch

class SolicitarViagemViewModel : ViewModel() {


    fun solictitarViagem(id: String, origin: String, destination: String){

        viewModelScope.launch {

            enviarRequest(id, origin, destination)

        }

    }

    suspend fun enviarRequest(id: String, origin: String, destination: String){
        val postsolicitarViagem = ShooperApi.createService(Endpoints::class.java)
        val gson = Gson()
        val requestBodyJson = gson.toJson(postsolicitarViagem)
        Log.d("POST_REQUEST_BODY", requestBodyJson)

        val response = postsolicitarViagem
        if (response.postEstimate(id, origin, destination).isSuccessful) {
            Log.d("POST", "POST request successful")

        } else {
//            Log.d(
////                "POST_ERROR", "POST request failed with code " +
////                        "${response.code()}: ${response.errorBody()?.string()}"
//            )
        }
    }


}