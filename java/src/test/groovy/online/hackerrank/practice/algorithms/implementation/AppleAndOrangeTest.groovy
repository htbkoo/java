package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class AppleAndOrangeTest extends Specification {
    @Unroll
    def "should return the total number of matching pairs of socks that John can sell"() {
        when:
        def actual = AppleAndOrange.Solution.countForTest(s, t, a, b, apples as int[], oranges as int[])

        then:
        actual == expected

        where:
        s | t  | a | b  | apples     | oranges || expected
        7 | 11 | 5 | 15 | [-2, 2, 1] | [5, -6] || ["1", "1"]

    }
}
