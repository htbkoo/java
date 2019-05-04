package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class FindAllAnagramsInAStringTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new FindAllAnagramsInAString.Solution().findAnagrams(s, p)

        then:
        actual.size() == expected.size()
        new HashSet<>(actual) == new HashSet<>(expected)

        where:
        s            | p               || expected
        "cbaebabacd" | "abc"           || [0, 6]
        "abab"       | "ab"            || [0, 1, 2]

        "cbabc"      | "abc"           || [0, 2]

        ""           | "a"             || []
        "aaaaaaaaaa" | "aaaaaaaaaaaaa" || []

//        "a"      | "" || []

    }
}
