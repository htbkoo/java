package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class NumberOfSegmentsInAStringTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new NumberOfSegmentsInAString.Solution().countSegments(s)

        then:
        actual == expected

        where:
        s                        || expected
        "  a     b  "            || 2
        "Hello, my name is John" || 5
    }
}
