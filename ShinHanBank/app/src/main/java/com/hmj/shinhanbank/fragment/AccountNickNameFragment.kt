package com.hmj.shinhanbank.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hmj.shinhanbank.R
import com.hmj.shinhanbank.databinding.FragmentAccountNickNameBinding

class AccountNickNameFragment : Fragment() {

    private lateinit var binding: FragmentAccountNickNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountNickNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (binding.accountNicknameEditText.text.isNotEmpty()) {
            binding.nextButton.setOnClickListener {
                findNavController().navigate(AccountNickNameFragmentDirections.actionAccountNickNameFragmentToAccountPasswordFragment(binding.accountNicknameEditText.text.toString()))
            }
        }
    }

}