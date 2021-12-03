package com.hmj.shinhanbank.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hmj.shinhanbank.R
import com.hmj.shinhanbank.databinding.FragmentInformationCheckBinding
import com.hmj.shinhanbank.network.dto.Request.AccountCheck
import com.hmj.shinhanbank.viewmodel.AccountViewModel

class InformationCheckFragment : Fragment() {

    private lateinit var binding: FragmentInformationCheckBinding
    private val args: InformationCheckFragmentArgs by navArgs()
    private val viewModel: AccountViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInformationCheckBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (args.state) {
            1 -> createAccount()
            2 -> addAccount()
        }
    }
    
    private fun createAccount() {
        binding.checkButton.text = "확인"
        binding.nextButton.text = "다음"
        binding.title.text = "실명정보 확인을 위해 \n이름과 주민등록번호를 \n입력하세요"
        if (binding.nameEditText.text.toString().isNotEmpty() && binding.numberEditText.text.toString().isNotEmpty()) {
            binding.checkButton.isEnabled = true
        }
        binding.checkButton.setOnClickListener {
            viewModel.accountCheck(
                AccountCheck(
                    binding.nameEditText.text.toString(),
                    binding.numberEditText.text.toString()
                )
            )
            viewModel.msg.observe(viewLifecycleOwner, {
                when (it.msg) {
                    "exist" -> Toast.makeText(requireContext(), "정보가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                    "success" -> {
                        Toast.makeText(requireContext(), "정보가 일치합니다.", Toast.LENGTH_SHORT).show()
                        binding.nextButton.visibility = View.VISIBLE
                    }
                }
            })
        }

        binding.nextButton.setOnClickListener {
            findNavController().navigate(InformationCheckFragmentDirections.actionInformationCheckFragmentToAccountNickNameFragment())
        }
    }

    private fun addAccount() {
        binding.checkButton.text = "조회하기"
        binding.title.text = "추가할 은행 확인을 위해\n이름과 주민등록번호를 입력하세요"
        binding.checkButton.setOnClickListener {
            findNavController().navigate(InformationCheckFragmentDirections.actionInformationCheckFragmentToMyAccountListFragment())
        }
    }
}
