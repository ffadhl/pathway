package com.fadhlalhafizh.pathway.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Job(
    val photo: Int,
    val position: String,
    val company: String,
    val domicile: String,
    val fullOrIntern: String,
    val description: String,
): Parcelable
