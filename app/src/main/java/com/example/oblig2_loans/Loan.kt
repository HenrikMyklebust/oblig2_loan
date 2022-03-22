package com.example.oblig2_loans

import com.example.oblig2_loans.result.Result
import kotlin.math.roundToInt

class Loan {


    fun calcLinear(amount: Int, interest: Double, length: Int, typeFixed: Boolean, typeLinear: Boolean): List<Result> {
        var results = mutableListOf<Result>()
        var deduction = calcDeduction(amount, length, typeFixed, typeLinear)
        var payedInterest = calcInterest(amount, interest, typeFixed, typeLinear)
        var term = calcTerm(deduction, payedInterest)
        var remaining = calcRemaining(amount,deduction)
        results.add(Result(1,term,payedInterest,deduction,remaining))
        for (i in 2.rangeTo(length)){
            payedInterest = calcInterest(term, interest, typeFixed, typeLinear)
            term = calcTerm(deduction, payedInterest)
            remaining = calcRemaining(term,deduction)
            results.add(Result(i,term,payedInterest,deduction,remaining))
        }
        return results
    }
    fun calcFixed(): List<Result> {
        // TODO()
        val results = mutableListOf<Result>()
        return results
    }

    fun calcDeduction(amount: Int, length: Int, typeFixed: Boolean, typeLinear: Boolean): Int{
        if (typeLinear)
            return amount / length
        else if (typeFixed)
            return 1
        return 0
    }

    fun calcInterest(amount: Int, interest: Double, typeFixed: Boolean, typeLinear: Boolean): Int{
        if (typeLinear)
            return (amount*(interest/100)).roundToInt()
        else if (typeFixed)
            return 1
        return 0
    }
    fun calcTerm(deduction: Int, interest: Int): Int {return deduction + interest}
    fun calcRemaining(amount: Int, deduction: Int): Int {return amount - deduction}

}