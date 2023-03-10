package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Catalogue(var list: MutableList<Shoe>?): Parcelable