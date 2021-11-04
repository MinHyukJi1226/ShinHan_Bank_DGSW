package com.hmj.shinhanbank.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.hmj.shinhanbank.R
import com.hmj.shinhanbank.activity.MainActivity
import com.hmj.shinhanbank.databinding.FragmentSignInBinding
import com.hmj.shinhanbank.databinding.FragmentSignInWithIdPwBinding
import com.hmj.shinhanbank.network.dto.Request.LoginRequest
import com.hmj.shinhanbank.util.PreferenceUtils
import com.hmj.shinhanbank.viewmodel.SignInViewModel
import kotlin.math.log

class SignInWithIdPwFragment : Fragment() {

    private lateinit var binding: FragmentSignInWithIdPwBinding
    private val viewModel: SignInViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInWithIdPwBinding.inflate(inflater, container, false)
        binding.loginButton.setOnClickListener {
            viewModel.login(loginRequest())
            observe()
        }
        return binding.root
    }

    private fun loginRequest() : LoginRequest = LoginRequest(
        binding.signInIdEditText.text.toString(),
        binding.signInPwEditText.text.toString()
    )

    private fun observe() {
        viewModel.signInLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                if (it.equals("fall")) {
                    Toast.makeText(context, "아이디 또는 패스워드가 틀렸습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    PreferenceUtils.token = it.msg
                    Toast.makeText(context, "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show()
                    Log.d("Login : ", "로그인 성공")
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)
                }
            } else {
                Toast.makeText(requireContext(), "서버 통신에 실패하였습니다.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}