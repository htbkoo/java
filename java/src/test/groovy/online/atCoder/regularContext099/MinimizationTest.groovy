package online.atCoder.regularContext099

import spock.lang.Specification
import spock.lang.Unroll

class MinimizationTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = Minimization.process(new Minimization.TestCase(N, K, a))

        then:
        result == String.valueOf(expected)

        where:
        N || K || a                        || expected
        4 || 3 || [2, 3, 1, 4]             || 2
        3 || 3 || [3, 1, 2]                || 1
        7 || 4 || [3, 2, 1, 4, 5, 6, 7]    || 2
        3 || 3 || [1, 2, 3,]               || 1
        8 || 3 || [1, 7, 3, 8, 4, 6, 2, 5] || 4
        8 || 3 || [7, 1, 3, 8, 4, 6, 2, 5] || 4
        8 || 3 || [7, 3, 1, 8, 4, 6, 2, 5] || 4
        8 || 3 || [7, 3, 8, 1, 4, 6, 2, 5] || 4
        8 || 3 || [7, 3, 8, 4, 1, 6, 2, 5] || 4
        8 || 3 || [7, 3, 8, 4, 6, 1, 2, 5] || 4
        8 || 3 || [7, 3, 8, 4, 6, 2, 1, 5] || 4
        8 || 3 || [7, 3, 8, 4, 6, 2, 5, 1] || 4
    }

}
