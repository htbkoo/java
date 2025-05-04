// https://www.codewars.com/kata/59cfc000aeb2844d16000075/train/kotlin

package com.heydev.java.online.codewars._7kyu

fun cap(text: String, isEvenCap: Boolean) : String {
    val s = StringBuilder()

    for (i in 0..text.length - 1) {
        if ((i % 2 == 0) == isEvenCap) {
            s.append(text[i].uppercase())
        } else {
            s.append(text[i].lowercase())
        }
    }

    return s.toString()
}

fun capitalize(text: String): List<String> {
    //TODO: Add your code!
    return listOf(cap(text, true), cap(text, false))
}
