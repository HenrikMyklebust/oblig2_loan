package com.example.oblig2_loans.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isGone
import androidx.fragment.app.viewModels
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oblig2_loans.R
import com.example.oblig2_loans.databinding.FragmentResultBinding
import com.example.oblig2_loans.result.ResultAdapter
import com.example.oblig2_loans.viewmodels.LoanViewModel
import com.example.oblig2_loans.result.Result


class ResultFragment : Fragment(R.layout.fragment_result) {

    lateinit var viewModel: LoanViewModel
    private lateinit var binding : FragmentResultBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentResultBinding.bind(view)


        var resultList = listOf<Result>()
        val preferenceManager = PreferenceManager.getDefaultSharedPreferences(view.context)
        if (!preferenceManager.getBoolean("cbTerm", true))
            binding.tvResultTerm.isGone = true
        if (!preferenceManager.getBoolean("cbInterest", true))
            binding.tvResultInterest.isGone = true
        if (!preferenceManager.getBoolean("cbDeduction", true))
            binding.tvResultDedution.isGone = true
        if (!preferenceManager.getBoolean("cbRemaining", true))
            binding.tvResultRemaining.isGone = true
        val adapter = ResultAdapter(resultList)
        binding.rvResult.adapter = adapter

        binding.rvResult.layoutManager = LinearLayoutManager(context)

    }
}