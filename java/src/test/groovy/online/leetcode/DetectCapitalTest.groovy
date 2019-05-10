package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class DetectCapitalTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new DetectCapital.Solution().detectCapitalUse(word)

        then:
        actual == expected

        where:
        word     || expected
        "USA"    || true
        "FlaG"   || false
        "Google" || true
    }
}
