package mx.org.bm.mvvmdm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.org.bm.mvvmdm.data.remote.AnimeProvider
import mx.org.bm.mvvmdm.data.remote.model.AnimeDto

class MainViewModel : ViewModel() {
    // Mutable
    private val _anime = MutableLiveData<AnimeDto>()

    // Solo lectura
    val anime: LiveData<AnimeDto> = _anime

    fun updateAnimeRestApi(){

        // viewModelScope especial para ViewModel, evita fugas de memoria
        viewModelScope.launch {
            _anime.postValue(AnimeProvider.getAnimeRestApi())
        }

    }
}