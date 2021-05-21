package com.example.mygardenmaker.data

import android.os.Parcelable
import androidx.room.Entity
import com.example.mygardenmaker.models.Building
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Garden(
    //val id: Int,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val gardenBuildings: List<Building>
):Parcelable