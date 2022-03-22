package com.example.oblig2_loans.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.oblig2_loans.R
import com.example.oblig2_loans.databinding.MainFragmentBinding
import com.example.oblig2_loans.viewmodels.LoanViewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    private lateinit var binding: MainFragmentBinding
    lateinit var viewModel: LoanViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        viewModel = ViewModelProvider(this).get(LoanViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        return binding.root
    }
}