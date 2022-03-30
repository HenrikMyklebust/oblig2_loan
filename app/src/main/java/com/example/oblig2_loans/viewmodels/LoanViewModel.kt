package com.example.oblig2_loans.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.oblig2_loans.Loan
import com.example.oblig2_loans.result.Result

class LoanViewModel : ViewModel() {

    val loan: Loan = Loan()
    val typeLinear = MutableLiveData(true)
    val typeFixed = MutableLiveData(false)
    val amount = MutableLiveData("")
    val interest = MutableLiveData("")
    val length = MutableLiveData("")

    fun calcLoan(): List<Result> {
        if (verifyInput())
            return loan.calcResult(amount.value!!, interest.value!!, length.value!!,
                typeFixed.value!!, typeLinear.value!!)
        else return emptyList()
    }

    private fun verifyInput(): Boolean{
        if (amount.value.equals("0") || amount.value.equals("") ||
            interest.value.equals("0") || interest.value.equals("") ||
            length.value.equals("0") || length.value.equals(""))
            return false
        return true
    }
}