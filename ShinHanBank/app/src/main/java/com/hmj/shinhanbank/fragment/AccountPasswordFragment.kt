package com.hmj.shinhanbank.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hmj.shinhanbank.R
import com.hmj.shinhanbank.databinding.FragmentAccountPasswordBinding
import com.hmj.shinhanbank.network.dto.Request.CreateAccount
import com.hmj.shinhanbank.viewmodel.AccountViewModel

class AccountPasswordFragment : Fragment() {

    private val args: AccountPasswordFragmentArgs by navArgs()
    private lateinit var binding: FragmentAccountPasswordBinding
    private val viewModel: AccountViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextButton.setOnClickListener {
            viewModel.createAccount(request())
            viewModel.msg.observe(viewLifecycleOwner, {
                when (it.msg) {
                    "success" -> findNavController().navigate(AccountPasswordFragmentDirections.actionAccountPasswordFragmentToCreateAccountSuccessFragment())
                }
            })
        }
    }

    private fun authNum(): String {
        return binding.input1.text.toString() + binding.input2.text.toString() + binding.input3.text.toString() +
                binding.input4.text.toString()
    }

    private fun request() = CreateAccount(args.nickname, authNum())
}