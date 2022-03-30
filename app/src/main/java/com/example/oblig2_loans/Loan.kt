package com.example.oblig2_loans

import com.example.oblig2_loans.result.Result
import kotlin.math.roundToInt

class Loan {



    fun calcResult(amount: String, interest: String, length: String, typeFixed: Boolean, typeLinear: Boolean): List<Result> {
        val doubleAmount = amount.toDouble()
        val doubleInterest = interest.toDouble()
        val intLength = length.toInt()
        if (typeLinear) {
            return calcLinear(doubleAmount, doubleInterest, intLength, typeFixed, typeLinear)
        }
        else
            return calcFixed(doubleAmount, doubleInterest, intLength, typeFixed, typeLinear)
    }


    private fun calcLinear(amount: Double, interest: Double, length: Int, typeFixed: Boolean, typeLinear: Boolean): List<Result> {
        val results = mutableListOf<Result>()
        val deduction = calcDeduction(amount, length, typeFixed, typeLinear)
        var payedInterest = calcInterest(amount, interest, typeFixed, typeLinear)
        var term = calcTerm(deduction, payedInterest)
        var remaining = calcRemaining(amount,deduction)
        results.add(Result(1,term,payedInterest,deduction,remaining))

        for (i in 2.rangeTo(length)){
            payedInterest = calcInterest(remaining, interest, typeFixed, typeLinear)
            term = calcTerm(deduction, payedInterest)
            remaining = calcRemaining(remaining,deduction)
            results.add(Result(i,term,payedInterest,deduction,remaining))
        }
        for (i in results){
            i.term = round(i.term)
            i.Interest = round(i.Interest)
            i.Deduction = round(i.Deduction)
            i.Remaining = round(i.Remaining)
        }
        return results
    }
    private fun calcFixed(amount: Double, interest: Double, length: Int, typeFixed: Boolean, typeLinear: Boolean): List<Result> {
        //var deduction = calcDeduction()
        //var payedInterest = calcInterest()
        //val term = calcTerm()
        val results = mutableListOf<Result>()
        return results
    }

    private fun calcDeduction(amount: Double, length: Int, typeFixed: Boolean, typeLinear: Boolean): Double{
        if (typeLinear)
            return amount / length
        else if (typeFixed)
            return 1.0
        return 0.0
    }

    private fun calcInterest(amount: Double, interest: Double, typeFixed: Boolean, typeLinear: Boolean): Double{
        if (typeLinear)
            return (amount*(interest/100))
        else if (typeFixed)
            return 1.0
        return 0.0
    }
    private fun calcTerm(deduction: Double, interest: Double): Double {return deduction + interest}
    private fun calcRemaining(amount: Double, deduction: Double): Double {return amount - deduction}

    private fun round(double: Double): Double{
        val doubleThreeDecimal: Double = Math.round(double * 1000.0) / 1000.0
        return Math.round(doubleThreeDecimal * 100.0) / 100.0
    }

}