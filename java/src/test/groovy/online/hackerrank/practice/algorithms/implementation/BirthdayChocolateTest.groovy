package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class BirthdayChocolateTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = BirthdayChocolate.Solution.birthday(s, d, m)

        then:
        actual == expected

        where:
        s                  | d | m || expected
        [1, 2, 1, 3, 2]    | 3 | 2 || 2
        [1, 1, 1, 1, 1, 1] | 3 | 2 || 0
        [4]                | 4 | 1 || 1
    }
}
