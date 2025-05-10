package online.codewars._5kyu

import com.heydev.java.online.codewars._5kyu.score
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GreedIsGoodTest {

    @Test
    fun shouldValueThisAsWorthless() {
        assertEquals(0, score(intArrayOf(2, 3, 4, 6, 2)), "Incorrect answer for dice = [2, 3, 4, 6, 2]")
    }

    @Test
    fun shouldValueThisTripletCorrectly() {
        assertEquals(400, score(intArrayOf(4, 4, 4, 3, 3)), "Incorrect answer for dice = [4, 4, 4, 3, 3]")
    }

    @Test
    fun shouldValueThisMixedSetCorrectly() {
        assertEquals(450, score(intArrayOf(2, 4, 4, 5, 4)), "Incorrect answer for dice = [2, 4, 4, 5, 4]")
    }
}
