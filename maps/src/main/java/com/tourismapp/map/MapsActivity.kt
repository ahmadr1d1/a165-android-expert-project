package com.tourismapp.map

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dicoding.tourismapp.core.data.Resource
import com.tourismapp.map.databinding.ActivityMapsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class MapsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMapsBinding
    private val mapsViewModel: MapsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadKoinModules(mapsModule)
        supportActionBar?.title = "Tourism Map"
        getTourismData()
    }

    private fun getTourismData() {
        mapsViewModel.tourism.observe(this) { tourism ->
            if (tourism != null) {
                when (tourism) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvMaps.text = "This is map of ${tourism.data?.get(0)?.name}"
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvError.visibility = View.VISIBLE
                        binding.tvError.text = tourism.message
                    }
                }
            }
        }
    }
}