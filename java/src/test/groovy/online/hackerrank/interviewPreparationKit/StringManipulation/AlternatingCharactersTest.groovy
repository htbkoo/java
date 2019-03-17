package online.hackerrank.interviewPreparationKit.StringManipulation

import spock.lang.Specification
import spock.lang.Unroll

class AlternatingCharactersTest extends Specification {
    @Unroll
    def "It should print the minimum number of deletions required on a new line"() {
        when:
        def actual = AlternatingCharacters.Solution.alternatingCharacters(s)

        then:
        actual == expected

        where:
        s          || expected
        "AAAA"     || 3
        "BBBBB"    || 4
        "ABABABAB" || 0
        "BABABA"   || 0
        "AAABBB"   || 4
    }
}
