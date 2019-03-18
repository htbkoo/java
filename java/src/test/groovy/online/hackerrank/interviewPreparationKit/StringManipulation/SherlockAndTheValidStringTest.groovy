package online.hackerrank.interviewPreparationKit.StringManipulation

import spock.lang.Specification
import spock.lang.Unroll

class SherlockAndTheValidStringTest extends Specification {

    @Unroll
    def "It should print the minimum number of deletions required on a new line"() {
        when:
        def actual = SherlockAndTheValidString.Solution.isValid(s)

        then:
        actual == expected

        where:
        s                   || expected
        "aabbcd"            || "NO"
        "aabbccddeefghi"    || "NO"
        "aabbc"             || "YES"
        "abcdefghhgfedecba" || "YES"
    }

}
