package com.udacity.shoestore.login.view

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.User

class LoginViewModel : ViewModel() {

    private val _actionPressed = MutableLiveData<Boolean>()
    val actionPressed: LiveData<Boolean>
    get() = _actionPressed

    private val _isEmailValid = MutableLiveData<Boolean>()
    val isEmailValid: LiveData<Boolean>
        get() = _isEmailValid

    private val _isPasswordValid = MutableLiveData<Boolean>()
    val isPasswordValid: LiveData<Boolean>
        get() = _isPasswordValid

    private val _validLogin = MutableLiveData<Boolean>()
    val validLogin: LiveData<Boolean>
        get() = _validLogin

    init {
        resetValues()
    }

    fun validateLogin(user: User) {
        val validatingEmail = validateEmail(user.email)
        val validatingPassword = validatePassword(user.password)
        _isEmailValid.value = validatingEmail
        _isPasswordValid.value = validatingPassword
        _validLogin.value = (validatingPassword && validatingEmail)
    }

    fun onActionPressed() {
        _actionPressed.value = true
    }

    fun onActionCompleted() {
        resetValues()
    }

    private fun resetValues() {
        _isEmailValid.value = true
        _isPasswordValid.value = true
        _validLogin.value = false
        _actionPressed.value = false
    }

    private fun validateEmail(email: String?): Boolean {
        email?.let {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches()
        } ?: return false
    }

    private fun validatePassword(password: String?) = !password.isNullOrBlank()
    fun resetActionPressed() {
        _actionPressed.value = false
    }
}