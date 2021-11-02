package com.hmj.shinhanbank.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hmj.shinhanbank.activity.MainActivity
import com.hmj.shinhanbank.databinding.FragmentAuthNumberBinding
import com.hmj.shinhanbank.network.dto.Request.LoginAuthNumRequest
import com.hmj.shinhanbank.network.dto.Request.SignUpAuthNumRequest
import com.hmj.shinhanbank.network.dto.Request.SignUpRequest
import com.hmj.shinhanbank.viewmodel.AuthNumViewModel

class AuthNumberFragment : Fragment() {

    private lateinit var binding: FragmentAuthNumberBinding
    private val args: AuthNumberFragmentArgs by navArgs()
    private val viewModel: AuthNumViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthNumberBinding.inflate(inflater, container, false)

        when (args.state) {
            1 -> signUp()
            2 -> signIn()
        }

        return binding.root
    }

    private fun signUp() {
        val signUpRequest = SignUpAuthNumRequest(authNum())
        viewModel.signUpAuth(signUpRequest)
        viewModel.authLiveData.observe(viewLifecycleOwner, {
            if (!it.equals("fail")) {
                Toast.makeText(requireContext(), "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show()
                toMain()
            }
        })
    }

    private fun signIn() {
        val loginAuthNumRequest = LoginAuthNumRequest(authNum())
        viewModel.signInAuth(loginAuthNumRequest)
        viewModel.authLiveData.observe(viewLifecycleOwner, {
            if (!it.equals("fail")) {
                Toast.makeText(requireContext(), "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show()
                toMain()
            }
        })
    }

    private fun authNum(): String {
        return binding.input1.text.toString() + binding.input2.text.toString() + binding.input3.text.toString() +
                binding.input4.text.toString() + binding.input5.text.toString() + binding.input6.text.toString()
    }

    private fun toMain() {
        val intent = Intent(requireContext(), MainActivity::class.java)
        startActivity(intent)
    }

}