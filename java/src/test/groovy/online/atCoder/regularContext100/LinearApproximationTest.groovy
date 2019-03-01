package online.atCoder.regularContext100

import spock.lang.Specification
import spock.lang.Unroll

class LinearApproximationTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = LinearApproximation.process(new LinearApproximation.TestCase(N,A))

        then:
        result == expected

        where:
        N || A                           || expected
        5 || [2, 2, 3, 5, 5]             || 2
        9 || [1, 2, 3, 4, 5, 6, 7, 8, 9] || 0
        6 || [6, 5, 4, 3, 2, 1]          || 18
        7 || [1, 1, 1, 1, 2, 3, 4]       || 6
    }


}
