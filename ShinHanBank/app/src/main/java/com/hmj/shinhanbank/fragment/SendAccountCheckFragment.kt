package com.hmj.shinhanbank.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hmj.shinhanbank.R
import com.hmj.shinhanbank.databinding.FragmentMyAccountListBinding
import com.hmj.shinhanbank.databinding.FragmentSendAccountCheckBinding

class SendAccountCheckFragment : Fragment() {

    private lateinit var binding: FragmentSendAccountCheckBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSendAccountCheckBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}