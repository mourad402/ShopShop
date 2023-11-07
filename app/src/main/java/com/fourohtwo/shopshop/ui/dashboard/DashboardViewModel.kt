package com.fourohtwo.shopshop.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fourohtwo.shopshop.repository.MainRepository
import com.fourohtwo.shopshop.data.model.MarsPhoto
import com.fourohtwo.shopshop.data.remote.MarsApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class MarsApiStatus { LOADING, ERROR, DONE }

@HiltViewModel
class DashboardViewModel @Inject constructor():ViewModel(){


    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<MarsApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<MarsApiStatus> = _status

    // Internally, we use a MutableLiveData, because we will be updating the List of MarsPhoto
    // with new values
    private val _photos = MutableLiveData<List<MarsPhoto>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val photos: LiveData<List<MarsPhoto>> = _photos

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */
    private fun getMarsPhotos() {


        Log.d("maaaars", "getMarsPhotos")
        viewModelScope.launch {
            Log.d("maaaars", "getMarsPhotos launch")

            _status.value = MarsApiStatus.LOADING
            try {
                _photos.value = MarsApi.retrofitService.getPhotos()
                _status.value = MarsApiStatus.DONE
                Log.d("maaaars", "getMarsPhotos _photos.value ${_photos.value}")

            } catch (e: Exception) {
                Log.e("maaaars", "getMarsPhotos error")
                e.printStackTrace()

                _status.value = MarsApiStatus.ERROR
                _photos.value = listOf()
            }
        }
    }
}