package com.udacity.shoestore.listing.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.udacity.shoestore.databinding.CardShoeBinding
import com.udacity.shoestore.models.Shoe

class ShoeCard @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attributeSet, defStyleAttr) {

    private val binding = CardShoeBinding.inflate(LayoutInflater.from(context), this, true)
    fun setShoeCard(shoe: Shoe) {
        with(binding) {
            shoeName.text = shoe.name
            shoeSize.text = shoe.size.toString()
            shoeCompany.text = shoe.company
            shoeDescription.text = shoe.description
        }
    }
}