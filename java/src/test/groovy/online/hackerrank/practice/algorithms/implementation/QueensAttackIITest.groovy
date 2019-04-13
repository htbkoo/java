package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class QueensAttackIITest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = QueensAttackII.Solution.queensAttack(n, k, r_q, c_q, obstacles as int[][])

        then:
        actual == expected

        where:
        n      | k | r_q   | c_q  | obstacles                 || expected
        100000 | 0 | 50000 | 5000 | []                        || 0
        4      | 0 | 4     | 4    | []                        || 9
        5      | 3 | 4     | 3    | [[5, 5], [4, 2], [2, 3],] || 10
        1      | 0 | 1     | 1    | []                        || 0
    }
}
