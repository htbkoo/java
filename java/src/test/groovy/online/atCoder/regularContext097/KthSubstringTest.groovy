package online.atCoder.regularContext097

import spock.lang.Specification
import spock.lang.Unroll

class KthSubstringTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = KthSubstring.process(new KthSubstring.TestCase(s, K))

        then:
        result == expected

        where:
        s                    || K || expected
        "aba"                || 4 || "b"
        "atcoderandatcodeer" || 5 || "andat"
        "z"                  || 1 || "z"
    }
}
