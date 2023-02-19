package com.udacity.shoestore.welcome.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    private val _navigateToInstructions = MutableLiveData<Boolean>()
    val navigateToInstructions : LiveData<Boolean>
        get() = _navigateToInstructions

    init {
        _navigateToInstructions.value = false
    }

    fun onActionPressed() {
        _navigateToInstructions.value = true
    }

    fun onActionCompleted() {
        _navigateToInstructions.value = false
    }
}