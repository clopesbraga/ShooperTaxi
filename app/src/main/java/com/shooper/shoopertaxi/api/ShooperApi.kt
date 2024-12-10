package com.shooper.shoopertaxi.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ShooperApi {

    companion object {
        private lateinit var instance: Retrofit
        private var baseUrl =
            "https://xd5zl5kk2yltomvw5fb37y3bm40vsyrx.lambda-url.sa-east-1.on.aws."

        private fun getInstance(): Retrofit {

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val httpClient = OkHttpClient.Builder()
            if (!::instance.isInitialized) {
                instance = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return instance

        }

        fun <S> createService(servicesClass: Class<S>): S {
            return getInstance().create(servicesClass)
        }

    }
}