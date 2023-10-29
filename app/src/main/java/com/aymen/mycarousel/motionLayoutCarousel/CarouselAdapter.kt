package com.aymen.mycarousel.motionLayoutCarousel

import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.helper.widget.Carousel
import androidx.constraintlayout.widget.ConstraintLayout
import com.aymen.mycarousel.R

class CarouselAdapter(
    private val list: List<Int>
): Carousel.Adapter {

    override fun count(): Int = list.size

    override fun populate(view: View?, index: Int) {
        if (view is ConstraintLayout) {
            val background = view.findViewById<ImageView>(R.id.imageView)
            background.setImageResource(list[index])
        }
    }

    override fun onNewItem(index: Int) {}
}