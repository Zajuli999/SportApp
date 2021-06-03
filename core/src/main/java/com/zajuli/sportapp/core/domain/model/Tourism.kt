package com.zajuli.sportapp.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tourism(
    val tourismId: String,
    val strSport: String,
    val strFormat: String,
    val strSportThumb: String,
    val strSportDescription: String,
    val isFavorite: Boolean
) : Parcelable