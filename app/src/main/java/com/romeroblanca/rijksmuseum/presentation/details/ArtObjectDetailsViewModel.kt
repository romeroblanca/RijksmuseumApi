package com.romeroblanca.rijksmuseum.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.romeroblanca.rijksmuseum.domain.model.artobjectdetailsmodel.ArtObjectDetailsModel
import com.romeroblanca.rijksmuseum.domain.usecase.GetArtObjectDetailsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArtObjectDetailsViewModel(
    private val getArtObjectDetailsUseCase: GetArtObjectDetailsUseCase
) : ViewModel() {

    private val _artObjectDetails = MutableLiveData<ArtObjectDetailsModel>()
    val artObjectDetails: LiveData<ArtObjectDetailsModel> get() = _artObjectDetails

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    fun getArtObjectDetails(id: String) = viewModelScope.launch {
        try {
            val result = withContext(Dispatchers.IO) {
                getArtObjectDetailsUseCase.invoke(id)
            }
            _artObjectDetails.value = result
        } catch (_: Throwable) {
            _errorMessage.value = "Error launched from ViewModel"
        }
    }
}