package com.example.consumirapi

import com.example.consumirapi.PerrosResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun obtenerPerrosPorRazas(@Url url: String): Response<PerrosResponse>
}