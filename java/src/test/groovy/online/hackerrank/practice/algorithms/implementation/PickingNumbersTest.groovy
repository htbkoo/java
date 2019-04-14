package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class PickingNumbersTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = PickingNumbers.Result.pickingNumbers(a)

        then:
        actual == expected

        where:
        a                           || expected
        [1, 1, 2, 2, 4, 4, 5, 5, 5] || 5
        [4, 6, 5, 3, 3, 1]          || 3
        [1, 2, 2, 3, 1, 2]          || 5
    }
}
