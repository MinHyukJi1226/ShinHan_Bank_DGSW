package com.hmj.shinhanbank.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hmj.shinhanbank.R
import com.hmj.shinhanbank.databinding.FragmentSignInBinding
import com.hmj.shinhanbank.databinding.FragmentSignInWithIdPwBinding

class SignInWithIdPwFragment : Fragment() {

    private lateinit var binding: FragmentSignInWithIdPwBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInWithIdPwBinding.inflate(inflater, container, false)
        return binding.root
    }
}