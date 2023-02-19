package com.udacity.shoestore.welcome.view

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
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import kotlinx.android.synthetic.main.activity_main.*

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    private lateinit var viewModel: WelcomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        setupTitleBar()
        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        binding.welcomeViewModel = viewModel
        binding.lifecycleOwner = this
        initializeObservers()
        return binding.root
    }

    private fun initializeObservers() {
        viewModel.navigateToInstructions.observe(viewLifecycleOwner, Observer { goToInstructions ->
            if (goToInstructions) {
                navigateToInstructions()
                viewModel.onActionCompleted()
            }
        })
    }

    private fun navigateToInstructions() {
        val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
        findNavController().navigate(action)
    }

    private fun setupTitleBar() {
        (activity as AppCompatActivity).toolbar.title = getString(R.string.welcome_label)
    }
}