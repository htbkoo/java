// https://www.codewars.com/kata/5270d0d18625160ada0000e4/train/kotlin

package com.heydev.java.online.codewars._5kyu

fun score(dice: IntArray): Int {
    val counter = mutableMapOf<Int, Int>().withDefault { 0 }
    dice.forEach { counter[it] = 1 + counter.getValue(it) }

    val POINTS_MAP_FOR_TRIPLE = mapOf(
        1 to 1000,
        2 to 200,
        3 to 300,
        4 to 400,
        5 to 500,
        6 to 600,
    )

    var answer = 0
    counter.forEach { v, count ->
        var remainCount = count
        while (remainCount >= 3) {
            answer += POINTS_MAP_FOR_TRIPLE.getValue(v)
            remainCount -= 3
        }
        if (v == 1) {
            answer += remainCount * 100
        } else if (v == 5) {
            answer += remainCount * 50
        }
    }

    return answer
}
