package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class KangarooTest extends Specification {
    @Unroll
    def "should return the total number of matching pairs of socks that John can sell"() {
        when:
        def actual = Kangaroo.Solution.kangaroo(x1, v1, x2, v2)

        then:
        actual == expected

        where:
        x1 | v1 | x2 | v2 || expected
        0  | 3  | 4  | 2  || "YES"
        0  | 2  | 5  | 3  || "NO"
    }
}
