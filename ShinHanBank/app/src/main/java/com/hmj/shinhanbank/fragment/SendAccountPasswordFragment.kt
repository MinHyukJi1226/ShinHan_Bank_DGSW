package com.hmj.shinhanbank.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hmj.shinhanbank.R
import com.hmj.shinhanbank.databinding.FragmentSendAccountPasswordBinding

class SendAccountPasswordFragment : Fragment() {

    private lateinit var binding: FragmentSendAccountPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSendAccountPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }
}