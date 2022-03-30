package com.example.oblig2_loans.result

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    val year: Int,
    var term: Double,
    var Interest: Double,
    var Deduction: Double,
    var Remaining: Double
) : Parcelable