package com.fourohtwo.shopshop.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {
    // Internally, we use a MutableLiveData, because we will be updating the List of MarsPhoto
    // with new values
    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    // The external LiveData interface to the property is immutable, so only this class can modify
    val text: LiveData<String> = _text
}