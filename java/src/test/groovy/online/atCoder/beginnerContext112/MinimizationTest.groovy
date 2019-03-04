package online.atCoder.beginnerContext112

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
        3 || 3 || [1, 2, 3,]               || 1
        8 || 3 || [7, 3, 1, 8, 4, 6, 2, 5] || 4
    }

}
