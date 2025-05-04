package online.codewars._6kyu

import com.heydev.java.online.codewars._6kyu.solution
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class SolutionTest {
    @Test
    fun basicTests() {
        assertEquals(listOf<String>(), solution(""), "Should handle empty string")
        assertEquals(listOf("ab", "cd", "ef"), solution("abcdef"), "Should handle even string")
        assertEquals(listOf("ab", "cd", "ef", "g_"), solution("abcdefg"), "Should handle odd string")
    }
}
