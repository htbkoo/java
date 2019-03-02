package online.atCoder.regularContext100

import spock.lang.Specification
import spock.lang.Unroll

class LinearApproximationTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = LinearApproximation.process(new LinearApproximation.TestCase(N, A))

        then:
        result == expected

        where:
        N || A                           || expected
        1 || [10]                        || 0
        2 || [1, 2]                      || 0
        2 || [2, 2]                      || 1
        2 || [2, 1]                      || 2
        2 || [3, 1]                      || 3
        2 || [3, 2]                      || 2
        5 || [1001, 1002, 3, 2, 2]       || 2005
        6 || [1001, 1002, 3, 5, 2, 2]    || 2008
        6 || [1001, 1002, 1, 5, 2, 2]    || 2010
        4 || [1001, 1002, 1, 2]          || 2004
        6 || [2, 1, 9, 12, 8, 6]         || 17
        5 || [1, 1, 1, 1, 1]             || 6
        5 || [0, 1, 2, 3, 4]             || 0
        5 || [2, 2, 3, 5, 5]             || 2
        5 || [2, 3, 4, 5, 6]             || 0
        5 || [2, 3, 7, 5, 7]             || 4
        9 || [1, 2, 3, 4, 5, 6, 7, 8, 9] || 0
        6 || [6, 5, 4, 3, 2, 1]          || 18
        6 || [1, 4, 1, 5, 1, 6]          || 9
        7 || [1, 1, 1, 1, 2, 3, 4]       || 6
    }


}
