package com.udacity.shoestore.details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.listing.view.ListingFragmentDirections
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.activity_main.*

class DetailsFragment: Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        setupTitleBar()
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        binding.save.setOnClickListener {
            val action = DetailsFragmentDirections.actionDetailsFragmentToListingFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }

    private fun setupTitleBar() {
        (activity as AppCompatActivity).toolbar.title = getString(R.string.details_fragment_title)
    }
}