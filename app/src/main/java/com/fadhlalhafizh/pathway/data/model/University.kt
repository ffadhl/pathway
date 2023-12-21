package com.fadhlalhafizh.pathway.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class University (
    val university: String,
    val address: String,
    val description: String,
    val worldRank: String,
    val photo: Int,
    val photoBackground: Int,
): Parcelable