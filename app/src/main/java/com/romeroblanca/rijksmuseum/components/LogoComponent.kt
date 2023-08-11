package com.romeroblanca.rijksmuseum.components

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import com.romeroblanca.rijksmuseum.R

class LogoComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val imageView: ImageView

    init {
        imageView = inflate(context, R.layout.component_rijksmuseum_logo, this)
            .findViewById(R.id.iv_rijksmuseum_logo)
        selectImage()
    }

    private fun selectImage() = imageView.setImageResource(
        R.drawable.rijksmuseum_logo
    )
}
