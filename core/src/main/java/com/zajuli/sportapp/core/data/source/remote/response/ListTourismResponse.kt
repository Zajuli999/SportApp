package com.zajuli.sportapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListTourismResponse(

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("sports")
    val places: List<TourismResponse>
)