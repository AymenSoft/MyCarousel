package com.aymen.mycarousel.recyclerViewCarousel

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aymen.mycarousel.R

class CarouselAdapter(
    private val images: List<Int>,
    private val onItemSelected: (Int) -> Unit
) : RecyclerView.Adapter<CarouselAdapter.VH>() {

    private var hasInitParentDimensions = false
    private var maxImageWidth: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        // At this point [parent] has been measured and has valid width & height
        if (!hasInitParentDimensions) {
            maxImageWidth =
                parent.width - (parent.resources.getDimensionPixelSize(R.dimen.carousel_spacing) * 6)
            hasInitParentDimensions = true
        }

        return VH(OverlayableImageView(parent.context))
    }

    override fun onBindViewHolder(vh: VH, position: Int) {
        val image = images[position]

        vh.overlayableImageView.layoutParams = RecyclerView.LayoutParams(
            maxImageWidth,
            RecyclerView.LayoutParams.MATCH_PARENT
        )

        // Load image
        vh.overlayableImageView.image = image

        vh.overlayableImageView.setOnClickListener {
            onItemSelected(position)
        }
    }

    override fun getItemCount(): Int = images.size

    class VH(val overlayableImageView: OverlayableImageView) :
        RecyclerView.ViewHolder(overlayableImageView)
}