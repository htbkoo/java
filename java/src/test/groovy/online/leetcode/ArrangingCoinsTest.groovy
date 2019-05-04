package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class ArrangingCoinsTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new ArrangingCoins.Solution().arrangeCoins(n)

        then:
        actual == expected

        where:
        n  || expected
        5  || 2
        8  || 3

        0  || 0
        1  || 1
        2  || 1
        3  || 2
        4  || 2
        6  || 3
        7  || 3
        9  || 3
        10 || 4
        11 || 4
        14 || 4
        15 || 5
        21 || 6
    }
}
