package com.hmj.shinhanbank.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hmj.shinhanbank.adapter.RecyclerViewMainAdapter
import com.hmj.shinhanbank.databinding.FragmentMainBinding
import com.hmj.shinhanbank.viewmodel.AccountViewModel

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: AccountViewModel by viewModels()
    private lateinit var recyclerViewAdapter: RecyclerViewMainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        binding.createLayout.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToInformationCheckFragment(1))
        }
    }

    private fun initRecyclerView() {
        binding.mainRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            recyclerViewAdapter = RecyclerViewMainAdapter()
            adapter = recyclerViewAdapter
        }
        viewModel.holdAccount()
        viewModel.accountLiveData.observe(viewLifecycleOwner, {
            if (it != null) {
                recyclerViewAdapter.setData(it)
            } else {
                recyclerViewAdapter.setData(listOf())
            }
        })
    }
}