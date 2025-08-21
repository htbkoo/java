// https://www.codewars.com/kata/55a29405bc7d2efaff00007c/train/kotlin

package com.heydev.java.online.codewars._5kyu

object Suite {

    fun going(n: Int): Double {
        // your code
        var answer = 0.0
        var curr = 1.0
        for (i in n downTo 1) {
            answer += curr
            curr /= i
        }
        return answer
    }
}
