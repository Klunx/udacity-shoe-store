package com.udacity.shoestore.instructions.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import kotlinx.android.synthetic.main.activity_main.*

class InstructionsFragment : Fragment() {
    private lateinit var binding: FragmentInstructionsBinding
    private lateinit var viewModel: InstructionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        setupTitleBar()
        viewModel = ViewModelProvider(this).get(InstructionsViewModel::class.java)
        binding.instructionsViewModel = viewModel
        binding.lifecycleOwner = this
        initializeObservers()
        return binding.root
    }

    private fun initializeObservers(){
        viewModel.navigateToShoeList.observe(viewLifecycleOwner, Observer{ navigateToShoeList ->
            if (navigateToShoeList) {
                goToShoeList()
                viewModel.onActionCompleted()
            }
        })
    }

    private fun goToShoeList() {
        val action = InstructionsFragmentDirections.actionInstructionsFragmentToListingFragment()
        findNavController().navigate(action)
    }

    private fun setupTitleBar() {
        (activity as AppCompatActivity).toolbar.title = getString(R.string.instructions_fragment_title)
    }
}