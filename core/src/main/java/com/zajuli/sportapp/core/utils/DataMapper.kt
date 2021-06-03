package com.zajuli.sportapp.core.utils

import com.zajuli.sportapp.core.data.source.local.entity.TourismEntity
import com.zajuli.sportapp.core.data.source.remote.response.TourismResponse
import com.zajuli.sportapp.core.domain.model.Tourism

object DataMapper {
    fun mapResponsesToEntities(input: List<TourismResponse>): List<TourismEntity> {
        val tourismList = ArrayList<TourismEntity>()
        input.map {
            val tourism = TourismEntity(
                tourismId = it.idSport,
                strSport = it.strSport,
                strFormat = it.strFormat,
                strSportThumb = it.strSportThumb,
                strSportDescription = it.strSportDescription,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<TourismEntity>): List<Tourism> =
        input.map {
            Tourism(
                tourismId = it.tourismId,
                strSport = it.strSport,
                strFormat = it.strFormat,
                strSportThumb = it.strSportThumb,
                strSportDescription = it.strSportDescription,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Tourism) = TourismEntity(
        tourismId = input.tourismId,
        strSport = input.strSport,
        strFormat = input.strFormat,
        strSportThumb = input.strSportThumb,
        strSportDescription = input.strSportDescription,
        isFavorite = input.isFavorite
    )
}