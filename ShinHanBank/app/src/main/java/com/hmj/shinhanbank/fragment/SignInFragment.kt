package com.hmj.shinhanbank.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.hmj.shinhanbank.R
import com.hmj.shinhanbank.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater, container, false)

        binding.signInWithIdPw.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_signInFragment_to_signInWithIdPwFragment)
        }

        binding.signInWithAuthNum.setOnClickListener {
            findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToAuthNumberFragment(2))
        }

        return binding.root
    }
}