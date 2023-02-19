package com.udacity.shoestore.instructions.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionsViewModel : ViewModel() {

    private val _navigateToShoeList = MutableLiveData<Boolean>()
    val navigateToShoeList : LiveData<Boolean>
        get() = _navigateToShoeList

    init {
        _navigateToShoeList.value = false
    }

    fun onActionPressed() {
        _navigateToShoeList.value = true
    }

    fun onActionCompleted() {
        _navigateToShoeList.value = false
    }
}