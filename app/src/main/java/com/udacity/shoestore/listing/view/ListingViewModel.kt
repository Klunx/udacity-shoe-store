package com.udacity.shoestore.listing.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Catalogue
import com.udacity.shoestore.models.Shoe

class ListingViewModel(shoe: Shoe?) : ViewModel() {

    private var _shouldNavigateToDetails = MutableLiveData<Boolean>()
    val shouldNavigateToDetails: LiveData<Boolean>
        get() = _shouldNavigateToDetails

    private var _shoeCatalogue = MutableLiveData<MutableList<Shoe>>()
    val shoeCatalogue: LiveData<MutableList<Shoe>>
        get() = _shoeCatalogue

    init {
        //shoe?.let { newShoe ->
        //    _shoeCatalogue.value?.add(newShoe)
        //}
        _shouldNavigateToDetails.value = false
    }

    fun onActionPressed() {
        _shouldNavigateToDetails.value = true
    }

    fun onActionCompleted() {
        _shouldNavigateToDetails.value = false
    }
}