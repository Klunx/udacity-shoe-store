package com.udacity.shoestore.details.view

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
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.utils.setGone
import com.udacity.shoestore.utils.setVisible
import com.udacity.shoestore.view.CatalogueViewModel
import kotlinx.android.synthetic.main.activity_main.*

/**
 *
 * Approach taken from:
 * https://knowledge.udacity.com/questions/804687 Diraj answer
 */
class DetailsFragment: Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel: DetailsViewModel
    private val catalogueViewModel by activityViewModels<CatalogueViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        setupTitleBar()
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        binding.detailsViewModel = viewModel
        binding.shoe = Shoe("",0.0, "", "")
        initializeObservers()
        return binding.root
    }

    private fun setupTitleBar() {
        (activity as AppCompatActivity).toolbar.title = getString(R.string.details_fragment_title)
    }

    private fun initializeObservers() {

        viewModel.newShoe.observe(viewLifecycleOwner, Observer {
            viewModel.validateShoe()
        })


        viewModel.isValidShoeName.observe(viewLifecycleOwner, Observer { isValidShoeName ->
            if (isValidShoeName) {
                binding.errorShoeName.setGone()
            } else {
                binding.errorShoeName.setVisible()
            }
        })

        viewModel.isValidCompany.observe(viewLifecycleOwner, Observer { isValidCompany ->
            if (isValidCompany) {
                binding.errorCompany.setGone()
            } else {
                binding.errorCompany.setVisible()
            }
        })

        viewModel.validSubmission.observe(viewLifecycleOwner, Observer { isValidSubmission ->
            if (isValidSubmission) {
                viewModel.newShoe.value?.let {
                    catalogueViewModel.addShoe(it)
                }
                navigateToListeningFragment()
            }
        })

        viewModel.cancelActionPressed.observe(viewLifecycleOwner, Observer { isCancelActionPressed ->
            if (isCancelActionPressed) {
                navigateToListeningFragment()
            }
        })
    }


    private fun navigateToListeningFragment() {
        val action = DetailsFragmentDirections.actionDetailsFragmentToListingFragment()
        findNavController().navigate(action)
    }
}