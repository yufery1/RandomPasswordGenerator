package com.example.randompasswordgenerator.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PasswordViewModel:ViewModel(){

    private val _generatedPassword = MutableLiveData<String>()
    val generatedPassword: LiveData<String> get() = _generatedPassword

    fun generatePassword() {
        val passwordLength = 16
        val randomPassword = generateRandomPassword(passwordLength)
        _generatedPassword.value = randomPassword
    }

    private fun generateRandomPassword(length: Int): String {
        val allowedChars = ('a'..'z') + ('A'..'Z') + ('0'..'9') + listOf('!', '@', '#', '$', '%', '^', '&', '*')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
}