package com.hmj.shinhanbank.fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hmj.shinhanbank.databinding.FragmentSignUpBinding
import com.hmj.shinhanbank.network.dto.Request.SignUpRequest
import com.hmj.shinhanbank.viewmodel.SignUpViewModel

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private val viewModel: SignUpViewModel by viewModels()

    private val REQ_GALLERY = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)

        binding.SelectPicture.setOnClickListener {
            openGallery()
        }

        binding.check.setOnClickListener {
            if (!binding.radio.isChecked) {
                Toast.makeText(requireContext(), "약관동의를 해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            observe()
            findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToAuthNumberFragment(1))
        }

        binding.cancel.setOnClickListener {
            findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToLoginFragment())
        }

        return binding.root
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        startActivityForResult(intent, REQ_GALLERY)
    }

    private fun observe() {
        viewModel.signUp(signUpRequest())
    }

    private fun signUpRequest() = SignUpRequest(
        binding.signUpIdEditText.text.toString(),
        binding.signUpPwEditText.text.toString(),
        binding.signUpPhoneEditText.text.toString(),
        binding.signUpResidentEditText.text.toString(),
        binding.signUpNameEditText.text.toString(),
        binding.signUpNickNameEditText.text.toString()
    )

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when(requestCode) {
                REQ_GALLERY -> {
                    viewModel.imgLiveData.value = data?.data
                    Log.d("img", viewModel.imgLiveData.value.toString())
                }
            }
        }
    }
}