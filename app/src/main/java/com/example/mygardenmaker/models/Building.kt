package com.example.mygardenmaker.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Building(val Name: String, val x: Int, val y: Int):Parcelable