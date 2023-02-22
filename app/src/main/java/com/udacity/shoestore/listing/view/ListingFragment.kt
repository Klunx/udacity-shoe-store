package com.udacity.shoestore.listing.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.view.CatalogueViewModel
import kotlinx.android.synthetic.main.activity_main.*

class ListingFragment : Fragment() {

    private lateinit var binding: FragmentListingBinding
    private lateinit var viewModel: ListingViewModel
    private val catalogueViewModel by activityViewModels<CatalogueViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setupTitleBar()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_listing, container, false)
        viewModel = ViewModelProvider(this).get(ListingViewModel::class.java)
        binding.listeningViewModel = viewModel
        binding.lifecycleOwner = this
        initializeObservers()
        return binding.root
    }

    private fun initializeObservers() {
        viewModel.shouldNavigateToDetails.observe(
            viewLifecycleOwner,
            Observer { shouldNavigateToDetails ->
                if (shouldNavigateToDetails) {
                    goToShoeDetails()
                    viewModel.onActionCompleted()
                }
            })

        catalogueViewModel.shoeCatalogue.observe(viewLifecycleOwner, Observer { listOfShoes ->
            binding.container.removeAllViews()
            listOfShoes.forEach {
                val card = ShoeCard(requireContext())
                card.setShoeCard(it)
                binding.container.addView(card)
            }
        })
    }

    private fun goToShoeDetails() {
        val action = ListingFragmentDirections.actionListingFragmentToDetailsFragment()
        findNavController().navigate(action)
    }

    private fun setupTitleBar() {
        (activity as AppCompatActivity).toolbar.title = getString(R.string.listing_fragment_title)
    }
}
