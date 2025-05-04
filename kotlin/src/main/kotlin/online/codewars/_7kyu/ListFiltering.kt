package com.heydev.java.online.codewars._7kyu

fun filterList(l: List<Any>): List<Int> {
    // Your answer
    return l.filter { it is Int } as List<Int>
}
