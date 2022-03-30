package com.example.oblig2_loans

import com.example.oblig2_loans.result.Result
import kotlin.math.pow
import kotlin.math.roundToInt

class Loan {

    private var payedInterest: Double = 0.0
    private var deduction: Double = 0.0
    private var remaining: Double = 0.0
    private var term: Double = 0.0

    fun calcResult(amount: String, interest: String, length: String, typeLinear: Boolean): List<Result> {
        val doubleAmount = amount.toDouble()
        val doubleInterest = interest.toDouble()
        val intLength = length.toInt()
        if (typeLinear) {
            return calcLinear(doubleAmount, doubleInterest, intLength)
        }
        else
            return calcFixed(doubleAmount, doubleInterest, intLength)
    }


    private fun calcLinear(amount: Double, interest: Double, length: Int): List<Result> {
        val results = mutableListOf<Result>()
        deduction = calcDeductionLinear(amount, length)
        payedInterest = calcInterest(amount, interest)
        term = calcTermLinear(deduction, payedInterest)
        remaining = calcRemaining(amount,deduction)
        results.add(Result(1,term,payedInterest,deduction,remaining))

        for (i in 2.rangeTo(length)){
            payedInterest = calcInterest(remaining, interest)
            term = calcTermLinear(deduction, payedInterest)
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
    private fun calcFixed(amount: Double, interest: Double, length: Int): List<Result> {
        val results = mutableListOf<Result>()
        term = calcTermFixed(amount, interest, length)
        payedInterest = calcInterest(amount, interest)
        deduction = calcDeductionFixed(term, payedInterest)
        remaining = calcRemaining(amount, deduction)
        results.add(Result(1,term,payedInterest,deduction,remaining))
            for (i in 2.rangeTo(length)) {
                payedInterest = calcInterest(remaining, interest)
                deduction = calcDeductionFixed(term, payedInterest)
                remaining = calcRemaining(remaining, deduction)
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


    private fun calcDeductionFixed(term: Double, interest: Double): Double {return term - interest}
    private fun calcDeductionLinear(amount: Double, length: Int): Double{return amount / length}
    private fun calcInterest(amount: Double, interest: Double): Double{return amount*(interest/100)}
    private fun calcRemaining(amount: Double, deduction: Double): Double {return amount - deduction}
    private fun calcTermLinear(deduction: Double, interest: Double): Double {return deduction + interest}
    private fun calcTermFixed(amount: Double, interest: Double, length: Int): Double{
        val percent = interest/100
        return amount * percent * (((1 + percent).pow(length)) / (((1 + percent).pow(length)) - 1))
    }

    private fun round(double: Double): Double{
        val doubleThreeDecimal: Double = Math.round(double * 1000.0) / 1000.0
        return Math.round(doubleThreeDecimal * 100.0) / 100.0
    }

}