// https://www.codewars.com/kata/5f0ed36164f2bc00283aed07/train/kotlin

package com.heydev.java.online.codewars._7kyu

fun overTheRoad(address: Int, n: Int): Int {
    // code here
    if (address % 2 == 0) {
        val idx = (address / 2) - 1
        val oppositeIdx = (n - 1) - idx
        return oppositeIdx * 2 + 1
    } else {
        val idx = (address - 1) / 2
        val oppositeIdx = (n - 1) - idx
        return (oppositeIdx + 1) * 2
    }
}
