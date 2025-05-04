// https://www.codewars.com/kata/515de9ae9dcfc28eb6000001/train/kotlin

package com.heydev.java.online.codewars._6kyu

fun split(s: String): List<String> {
    val l = mutableListOf<String>()
    for (i in 0..s.length - 1 step 2) {
        l.add(s.substring(i, i + 2))
    }
    return l
}

fun solution(s: String): List<String> {
    if (s.length % 2 == 0) {
        return split(s)
    } else {
        return split(s + "_")
    }
}
