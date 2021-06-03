package com.zajuli.sportapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TourismResponse(
    @field:SerializedName("idSport")
    val idSport: String,

    @field:SerializedName("strSport")
    val strSport: String,
    @field:SerializedName("strFormat")
    val strFormat: String,
    @field:SerializedName("strSportThumb")
    val strSportThumb: String,

    @field:SerializedName("strSportDescription")
    val strSportDescription: String
)



