package mx.org.bm.mvvmdm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import mx.org.bm.mvvmdm.R
import mx.org.bm.mvvmdm.data.remote.model.AnimeDto
import mx.org.bm.mvvmdm.databinding.ActivityMainBinding
import mx.org.bm.mvvmdm.ui.adapter.AnimesAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var animes = mutableListOf<AnimeDto>()

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myAdapter = AnimesAdapter(animes)
        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myAdapter
        }

        binding.btnAdd.setOnClickListener {
            mainViewModel.updateAnimeRestApi()
        }

        mainViewModel.anime.observe(this, Observer {anime ->
            animes.add(anime)

            myAdapter.notifyItemInserted(animes.size-1)
        })
    }
}