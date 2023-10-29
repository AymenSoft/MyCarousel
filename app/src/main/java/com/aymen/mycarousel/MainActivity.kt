package com.aymen.mycarousel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aymen.mycarousel.databinding.ActivityMainBinding
import com.aymen.mycarousel.motionLayoutCarousel.MotionLayoutActivity
import com.aymen.mycarousel.recyclerViewCarousel.RecyclerViewActivity

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            btnMotionLayout.setOnClickListener {
                startActivity(Intent(this@MainActivity, MotionLayoutActivity::class.java))
            }
            btnRecyclerView.setOnClickListener {
                startActivity(Intent(this@MainActivity, RecyclerViewActivity::class.java))
            }
        }
    }

}