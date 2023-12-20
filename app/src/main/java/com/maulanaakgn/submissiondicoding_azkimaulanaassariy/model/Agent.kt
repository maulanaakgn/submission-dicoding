package com.maulanaakgn.submissiondicoding_azkimaulanaassariy.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Agent(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
