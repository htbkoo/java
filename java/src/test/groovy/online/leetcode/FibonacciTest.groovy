package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class FibonacciTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new Fibonacci.Solution().fib(N)

        then:
        actual == expected

        where:
        N  || expected
        20 || 6765
        0  || 0
        1  || 1
        2  || 1
        3  || 2
        4  || 3
        5  || 5
        6  || 8
    }
}
