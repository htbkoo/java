package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class BinaryNumberWithAlternatingBitsTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new BinaryNumberWithAlternatingBits.Solution().hasAlternatingBits(n)

        then:
        actual == expected

        where:
        n      || expected
        5      || true
        10     || true
        7      || false
        11     || false
        208934 || false

        0      || true
        1      || true
        2      || true
        3      || false
        4      || false
        6      || false
    }
}
