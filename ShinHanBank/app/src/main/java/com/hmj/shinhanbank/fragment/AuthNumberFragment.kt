package com.hmj.shinhanbank.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.hmj.shinhanbank.R
import com.hmj.shinhanbank.databinding.FragmentAuthNumberBinding

class AuthNumberFragment : Fragment() {

    private lateinit var binding: FragmentAuthNumberBinding
    private val args: AuthNumberFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthNumberBinding.inflate(inflater, container, false)

        when(args.state){
            1 -> signUp()
            2 -> signIn()
        }

        return binding.root
    }

    private fun signUp() {

    }

    private fun signIn() {

    }

}