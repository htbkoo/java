package online.hackerrank.practice.dataStructures.stacks

import spock.lang.Specification
import spock.lang.Unroll

class EqualStacksTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = EqualStacks.Solution.equalStacks(h1 as int[], h2 as int[], h3 as int[])

        then:
        actual == expected

        where:
        h1              | h2        | h3           || expected
        [3, 2, 1, 1, 1] | [4, 3, 2] | [1, 1, 4, 1] || 5
    }
}
