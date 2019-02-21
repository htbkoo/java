package online.atCoder.beginnerContext118

import spock.lang.Specification
import spock.lang.Unroll

class MatchMatchingTest extends Specification {
    @Unroll
    def "should find minimum"() {
        when:
        def minHealth = MatchMatching.findLargestNumber(new MatchMatching.TestCase(N, A))

        then:
        minHealth == expected

        where:
        N   || A                           || expected
        20  || [3, 7, 8, 4]                || "777773"
        101 || [9, 8, 7, 6, 5, 4, 3, 2, 1] || "71111111111111111111111111111111111111111111111111"
        15  || [6, 5, 4]                   || "654"
    }
}
