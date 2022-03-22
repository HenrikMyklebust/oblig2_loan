package com.example.oblig2_loans.viewmodels


import androidx.databinding.InverseBindingMethods
import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.oblig2_loans.Loan

open class LoanViewModel : ViewModel() {

    val loan: Loan = Loan()

    // Radio button for linear loan
    private val _typeLinear = MutableLiveData(true)
    val typeLinear: LiveData<Boolean>
        get() = _typeLinear

    // Radio button for fixed-rate loan
    private val _typeFixed = MutableLiveData(false)
    val typeFixed: LiveData<Boolean>
        get() = _typeFixed

    // Loan amount field
    private val _amount = MutableLiveData("")
    val amount: LiveData<String>
        get() = _amount

    // Interest rate field
    private val _interest = MutableLiveData("")
    val interest: LiveData<String>
        get() = _interest

    // DownPayment time length
    private val _length = MutableLiveData("")
    val length: LiveData<String>
        get() = _length


    fun calculate() {
        println("HELLLO DIS IS DOGE")
    }

}