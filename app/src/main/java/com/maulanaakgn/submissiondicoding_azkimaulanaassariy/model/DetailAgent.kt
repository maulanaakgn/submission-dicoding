package com.maulanaakgn.submissiondicoding_azkimaulanaassariy.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailAgent(
    val name: String,
    val role: String,
    val description: String,
    val photo: Int,
    val skill_q: Int,
    val skill_e: Int,
    val skill_c: Int,
    val skill_x: Int,
    val skillnameq: String,
    val skillnamee: String,
    val skillnamec: String,
    val skillnamex: String,
    val skilldescq: String,
    val skilldesce: String,
    val skilldescc: String,
    val skilldescx: String
) : Parcelable
