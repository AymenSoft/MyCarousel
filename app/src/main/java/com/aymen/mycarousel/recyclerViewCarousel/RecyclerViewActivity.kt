package com.aymen.mycarousel.recyclerViewCarousel

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnPreDraw
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.aymen.mycarousel.R
import com.aymen.mycarousel.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity: AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding

    private var images = mutableListOf(
        R.drawable.bryce_canyon,
        R.drawable.cathedral_rock,
        R.drawable.death_valley,
        R.drawable.fitzgerald_marine_reserve,
        R.drawable.goldengate,
        R.drawable.golden_gate_bridge,
        R.drawable.shipwreck_1,
        R.drawable.shipwreck_2,
        R.drawable.grand_canyon,
        R.drawable.horseshoe_bend,
        R.drawable.muir_beach,
        R.drawable.rainbow_falls,
    )

    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: CarouselAdapter
    private lateinit var snapHelper: SnapHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = ProminentLayoutManager(this)
        adapter = CarouselAdapter(
            images = images,
            onItemSelected = {
                Toast.makeText(this, "position: $it", Toast.LENGTH_SHORT).show()
            }
        )
        snapHelper = PagerSnapHelper()

        with(binding.rvCarousel) {
            setItemViewCacheSize(4)
            layoutManager = this@RecyclerViewActivity.layoutManager
            adapter = this@RecyclerViewActivity.adapter

            val spacing = resources.getDimensionPixelSize(R.dimen.carousel_spacing)
            addItemDecoration(LinearHorizontalSpacingDecoration(spacing))
            addItemDecoration(BoundsOffsetDecoration())

            snapHelper.attachToRecyclerView(this)
        }

        initRecyclerViewPosition()
    }

    private fun initRecyclerViewPosition() {
        // This initial scroll will be slightly off because it doesn't respect the SnapHelper.
        // Do it anyway so that the target view is laid out, then adjust onPreDraw.
        layoutManager.scrollToPosition(0)

        binding.rvCarousel.doOnPreDraw {
            val targetView = layoutManager.findViewByPosition(0) ?: return@doOnPreDraw
            val distanceToFinalSnap =
                snapHelper.calculateDistanceToFinalSnap(layoutManager, targetView)
                    ?: return@doOnPreDraw

            layoutManager.scrollToPositionWithOffset(0, -distanceToFinalSnap[0])
        }
    }

}