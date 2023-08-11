package com.romeroblanca.rijksmuseum.presentation.collection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.romeroblanca.rijksmuseum.domain.model.artcollectionmodel.ArtCollectionModel
import com.romeroblanca.rijksmuseum.domain.usecase.GetArtCollectionUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArtCollectionViewModel(
    private val getArtCollectionUseCase: GetArtCollectionUseCase
) : ViewModel() {

    private val _artCollection = MutableLiveData<ArtCollectionModel>()
    val artCollection: LiveData<ArtCollectionModel> get() = _artCollection

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            //examples.exampleFold()
            try {
                _errorMessage.value = null
                val result = withContext(Dispatchers.IO) {
                    getArtCollectionUseCase.invoke()
                }
                _artCollection.value = result
            } catch (t: Throwable) {
                _errorMessage.value = "Error unknown"
            }
        }
    }

}
