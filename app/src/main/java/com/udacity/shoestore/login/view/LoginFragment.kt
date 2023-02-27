package com.udacity.shoestore.login.view

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
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.User
import com.udacity.shoestore.utils.setGone
import com.udacity.shoestore.utils.setVisible
import kotlinx.android.synthetic.main.activity_main.*

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        setupScreen()
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginViewModel = viewModel
        binding.user = User("", "")
        initializeObservers()
        return binding.root
    }

    private fun initializeObservers() {

        viewModel.isEmailValid.observe(viewLifecycleOwner, Observer { isValid ->
            if (isValid) {
                binding.emailError.setGone()
            } else {
                binding.emailError.setVisible()
            }
        })

        viewModel.isPasswordValid.observe(viewLifecycleOwner, Observer { isValid ->
            if (isValid) {
                binding.passwordError.setGone()
            } else {
                binding.passwordError.setVisible()
            }
        })

        viewModel.validLogin.observe(viewLifecycleOwner, Observer { isValid ->
            if (isValid) {
                goToWelcomeScreen()
                viewModel.onActionCompleted()
            }
        })
    }

    private fun goToWelcomeScreen() {
        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
        findNavController().navigate(action)
    }

    private fun setupScreen() {
        (activity as AppCompatActivity).toolbar.title = ""
        (activity as AppCompatActivity).toolbar.menu.clear()
    }
}