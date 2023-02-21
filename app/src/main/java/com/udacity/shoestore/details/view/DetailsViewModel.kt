package com.udacity.shoestore.details.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.utils.validateDescription

class DetailsViewModel : ViewModel() {

    private val _isValidShoeName = MutableLiveData<Boolean>()
    val isValidShoeName: LiveData<Boolean>
        get() = _isValidShoeName

    private val _isValidCompany = MutableLiveData<Boolean>()
    val isValidCompany: LiveData<Boolean>
        get() = _isValidCompany

    private val _isValidSubmission = MutableLiveData<Boolean>()
    val validSubmission: LiveData<Boolean>
        get() = _isValidSubmission
/*
    private val _saveActionPressed = MutableLiveData<Boolean>()
    val saveActionPressed: LiveData<Boolean>
        get() = _saveActionPressed
*/
    private val _cancelActionPressed = MutableLiveData<Boolean>()
    val cancelActionPressed: LiveData<Boolean>
        get() = _cancelActionPressed

    private val _newShoe = MutableLiveData<Shoe>()
    val newShoe: LiveData<Shoe>
        get() = _newShoe

    init {
        //_saveActionPressed.value = false
        _cancelActionPressed.value = false
    }

    fun onSavePressed(shoe: Shoe) {
       // _saveActionPressed.value = true
        shoe.description = shoe.description.validateDescription()
        _newShoe.value = shoe
    }

    fun onCancelPressed() {
        _cancelActionPressed.value = true
    }

    fun validateShoe() {
        val validName = validateField(_newShoe.value?.name)
        val validCompany = validateField(_newShoe.value?.company)
        _isValidShoeName.value = validName
        _isValidCompany.value = validCompany
        if (validName && validCompany) {
            _isValidSubmission.value = true
        }
    }

    private fun validateField(field: String?) = !field.isNullOrBlank()
}