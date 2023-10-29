package com.aymen.mycarousel.motionLayoutCarousel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aymen.mycarousel.R
import com.aymen.mycarousel.databinding.ActivityMotionLayoutBinding

class MotionLayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMotionLayoutBinding

    private var numSlides = 1

    private var images = intArrayOf(
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMotionLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.carousel.setAdapter(CarouselAdapter(images.take(numSlides)))

        binding.btnAdd.setOnClickListener {
            if (numSlides < images.size) {
                numSlides++
                binding.carousel.setAdapter(CarouselAdapter(images.take(numSlides)))
                binding.carousel.refresh()
            } else {
                numSlides = 1
                binding.carousel.setAdapter(CarouselAdapter(images.take(numSlides)))
                binding.carousel.refresh()
                binding.carousel.jumpToIndex(1)
            }
        }
    }
}