package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class MigratoryBirdsTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = MigratoryBirds.Solution.migratoryBirds(arr)

        then:
        actual == expected

        where:
        arr                               || expected
        [1, 4, 4, 4, 5, 3]                || 4
        [1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4] || 3
    }
}
