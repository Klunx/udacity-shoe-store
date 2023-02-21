package com.udacity.shoestore.listing.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.models.Catalogue
import com.udacity.shoestore.models.Shoe

class ListingViewModelFactory (private val shoe: Shoe?) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListingViewModel::class.java)) {
            return ListingViewModel(shoe) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}