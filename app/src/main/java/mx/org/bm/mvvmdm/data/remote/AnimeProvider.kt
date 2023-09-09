package mx.org.bm.mvvmdm.data.remote

import kotlinx.coroutines.delay
import mx.org.bm.mvvmdm.data.remote.model.AnimeDto

class AnimeProvider {

    companion object{
        private val animes = mutableListOf<AnimeDto>()

        init {
            for (i in 1 .. 40){
                animes
                    .add(AnimeDto(i.toLong(), "Título $i", "Tipo $i", "Fecha $i"))
            }
        }

        suspend fun getAnimeRestApi(): AnimeDto{
            val position = (0..39).random()

            delay(2000)
            return animes[position]
        }
    }
}