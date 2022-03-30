package com.example.oblig2_loans.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.oblig2_loans.R
import com.example.oblig2_loans.databinding.MainFragmentBinding
import com.example.oblig2_loans.viewmodels.LoanViewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    private lateinit var binding: MainFragmentBinding
    lateinit var viewModel: LoanViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        viewModel = ViewModelProvider(this).get(LoanViewModel::class.java)
        val navigation = NavHostFragment.create(R.navigation.my_nav)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.btnCalculate.setOnClickListener {
            val result = viewModel.calcLoan()
            if (result.isEmpty()) {
                Toast.makeText(context, R.string.toastCheck, Toast.LENGTH_SHORT).show()
            } else {
                val action =
                    MainFragmentDirections.actionMainFragmentToResultFragment(result.toTypedArray())
                Navigation.findNavController(binding.root).navigate(action)
            }
        }

        return binding.root
    }
}