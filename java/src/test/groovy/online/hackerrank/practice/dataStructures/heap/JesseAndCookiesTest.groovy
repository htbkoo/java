package online.hackerrank.practice.dataStructures.heap

import spock.lang.Specification
import spock.lang.Unroll

class JesseAndCookiesTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = JesseAndCookies.Solution.cookies(k, A as int[])

        then:
        actual == expected

        where:
        k | A                    || expected
        7 | [1, 2, 3, 9, 10, 12] || 2
    }
}
