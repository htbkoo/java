package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class RotateStringTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def num = new RotateString.Solution().rotateString(A, B)

        then:
        num == expected

        where:
        A       | B       || expected
        'abcde' | 'cdeab' || true
        'abcde' | 'abced' || false
        "aa"    | "a"     || false
    }
}
