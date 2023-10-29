package com.aymen.mycarousel.recyclerViewCarousel

import android.animation.LayoutTransition
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isInvisible
import com.aymen.mycarousel.databinding.ViewOverlayableImageBinding

class OverlayableImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = ViewOverlayableImageBinding.inflate(LayoutInflater.from(context), this)

    var image: Int? = null
        set(value) {
            field = value
            value?.let {
                binding.imageView.setImageResource(it)
            }
        }


    init {
        layoutTransition = LayoutTransition() // android:animateLayoutChanges="true"
        isActivated = false
    }

    override fun setActivated(activated: Boolean) {
        val isChanging = activated != isActivated
        super.setActivated(activated)

        if (isChanging) {
            // Switch between VISIBLE and INVISIBLE
            //binding.sendButton.isInvisible = !activated
        }
    }
}