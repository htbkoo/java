// https://www.codewars.com/kata/56484848ba95170a8000004d/train/kotlin

package com.heydev.java.online.codewars._7kyu

import kotlin.math.floor
import kotlin.math.max

fun gps(s: Int, x: DoubleArray): Int {
    // your code
    var answer = 0
    for (i in 1..x.size - 1) {
        val dist = x[i] - x[i - 1];
        answer = max(answer, floor((3600 * dist) / s).toInt())
    }
    return answer
}
