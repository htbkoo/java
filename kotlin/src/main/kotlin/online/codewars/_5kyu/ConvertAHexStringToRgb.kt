// https://www.codewars.com/kata/5282b48bb70058e4c4000fa7/train/kotlin

package com.heydev.java.online.codewars._5kyu

data class RGB(val r: Int, val g: Int, val b: Int)

// you have preloaded
// data class RGB(val r: Int, val g: Int, val b: Int)
fun hexStringToRGB(hexString: String): RGB {
    return RGB(
        hexToInt(hexString.substring(1..2)),
        hexToInt(hexString.substring(3..4)),
        hexToInt(hexString.substring(5..6)),
    )
}

fun hexToInt(hex: String): Int {
    val ZERO_CODE = '0'.code
    val LOWER_A_CODE = 'a'.code

    var dec = 0
    for (ch in hex) {
        dec *= 16
        if ('0' <= ch && ch <= '9') {
            dec += ch.code - ZERO_CODE
        } else if ('a' <= ch.lowercaseChar() && ch.lowercaseChar() <= 'f') {
            dec += 10 + ch.lowercaseChar().code - LOWER_A_CODE
        } else {
            throw IllegalArgumentException()
        }
    }
    return dec
}
