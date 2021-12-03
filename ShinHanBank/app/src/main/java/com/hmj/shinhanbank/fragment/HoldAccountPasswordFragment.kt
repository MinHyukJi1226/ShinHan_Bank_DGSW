package com.hmj.shinhanbank.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hmj.shinhanbank.R
import com.hmj.shinhanbank.databinding.FragmentHoldAccountPasswordBinding

class HoldAccountPasswordFragment : Fragment() {

    private lateinit var binding: FragmentHoldAccountPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHoldAccountPasswordBinding.inflate(inflater, container, false )
        return binding.root
    }
}   