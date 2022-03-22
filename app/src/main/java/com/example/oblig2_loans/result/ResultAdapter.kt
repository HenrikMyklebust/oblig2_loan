package com.example.oblig2_loans.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oblig2_loans.databinding.ResultLineBinding

class ResultAdapter(
    var results: List<Result>
) : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder(ResultLineBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.bind(results[position])

    }

    override fun getItemCount(): Int {
        return results.size
    }

    class ResultViewHolder(private val binding : ResultLineBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(result: Result) {
            val preferenceManager = PreferenceManager.getDefaultSharedPreferences(itemView.context)
            if (!preferenceManager.getBoolean("cbTerm", true))
                binding.tvLineTerm.isGone = true
            if (!preferenceManager.getBoolean("cbInterest", true))
                binding.tvLineInterest.isGone = true
            if (!preferenceManager.getBoolean("cbDeduction", true))
                binding.tvLineDedution.isGone = true
            if (!preferenceManager.getBoolean("cbRemaining", true))
                binding.tvLineRemaining.isGone = true
            binding.result = result
        }
    }
}