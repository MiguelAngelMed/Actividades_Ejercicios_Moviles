package com.example.consumirapi

import com.google.gson.annotations.SerializedName


data class PerrosResponse (
    @SerializedName("status")
    var status: String,
    @SerializedName ("message")
    var images: List<String>
)