// https://www.codewars.com/kata/53dbd5315a3c69eed20002dd/train/kotlin

package com.heydev.java.online.codewars._7kyu

fun filterList(l: List<Any>): List<Int> {
    // Your answer
    return l.filterIsInstance<Int>()
}

fun firstFilterList(l: List<Any>): List<Int> {
    // Your answer
    return l.filter { it is Int } as List<Int>
}
