package com.udacity.shoestore.listing.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class ShoeCard : ConstraintLayout {

    private lateinit var shoeName: TextView
    private lateinit var shoeSize: TextView
    private lateinit var shoeCompany: TextView
    private lateinit var shoeDescription: TextView

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.card_shoe, this)
        this.shoeName = findViewById(R.id.shoe_name)
        this.shoeSize = findViewById(R.id.shoe_size)
        this.shoeCompany = findViewById(R.id.shoe_company)
        this.shoeDescription = findViewById(R.id.shoe_description)
    }

    fun setShoeCard(shoe: Shoe) {
        shoeName.text = shoe.name
        shoeSize.text = shoe.size.toString()
        shoeCompany.text = shoe.company
        shoeDescription.text = shoe.description
    }
}