package com.example.oblig2_loans

import org.junit.Test
import org.junit.Assert.*
import kotlin.math.roundToInt

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LoanUnitTest {
    private val loan = Loan()

    @Test
    fun loanCalculatorFixedTest() {
        assertTrue(loan.calcResult("200000", "3.6", "12", false)[5].Remaining
                == 110570.51)

        assertTrue(loan.calcResult("200000", "3.6", "12", false)[6].Deduction
                == 16838.24)

        assertTrue(loan.calcResult("400000", "1.2", "15", false)[12].Remaining
                == 57557.67)
    }

     @Test
     fun loanCalculatorLinearTest() {
         assertTrue(loan.calcResult("250000", "5", "25", true)[20].Remaining.roundToInt()
                 == 40000)

         assertTrue(loan.calcResult("250000", "1.2", "25", true)[20].Interest.roundToInt()
                 == 600)
     }
}