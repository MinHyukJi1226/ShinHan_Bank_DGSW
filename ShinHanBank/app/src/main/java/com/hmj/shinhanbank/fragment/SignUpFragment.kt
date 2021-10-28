package com.hmj.shinhanbank.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hmj.shinhanbank.R
import com.hmj.shinhanbank.databinding.FragmentSignUpBinding
import com.hmj.shinhanbank.viewmodel.SignUpViewModel

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)

        binding.check.setOnClickListener {
            findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToAuthNumberFragment(1))
        }

        binding.cancel.setOnClickListener {
            findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToLoginFragment())
        }

        return binding.root
    }
}