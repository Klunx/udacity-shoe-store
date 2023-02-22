package com.udacity.shoestore.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class CatalogueViewModel : ViewModel() {

    private var _shoeCatalogue = MutableLiveData<MutableList<Shoe>>()
    val shoeCatalogue: LiveData<MutableList<Shoe>>
        get() = _shoeCatalogue

    init {
        _shoeCatalogue.value = mutableListOf()
    }

    fun addShoe(shoe: Shoe) {
        _shoeCatalogue.value?.add(shoe)
    }
}