package com.zajuli.favorit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.zajuli.favorit.databinding.ActivityFavoritBinding
import com.zajuli.favorit.di.favoritviewModelModule
import com.zajuli.favorit.favorite.FavoriteViewModel
import com.zajuli.sportapp.core.data.Resource
import com.zajuli.sportapp.core.ui.TourismAdapter
import com.zajuli.sportapp.detail.DetailTourismActivity
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoritActivity : AppCompatActivity() {

    private val favoritViewModel: FavoriteViewModel by viewModel()
    private var _binding: ActivityFavoritBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFavoritBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoritviewModelModule)

        supportActionBar?.title = "Tourism Favorit"

        getTourismData()
    }

    private fun getTourismData() {
        if (this != null) {

            val tourismAdapter = TourismAdapter()
            tourismAdapter.onItemClick = { selectedData ->
                val intent = Intent(this, DetailTourismActivity::class.java)
                intent.putExtra(DetailTourismActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            favoritViewModel.favoriteTourism.observe(this, { dataTourism ->
                tourismAdapter.setData(dataTourism)
                binding.viewEmpty.root.visibility = if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.rvTourism) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tourismAdapter
            }
        }
    }

}