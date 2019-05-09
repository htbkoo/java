package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class ReverseOnlyLettersTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new ReverseOnlyLetters.Solution().reverseOnlyLetters(S)

        then:
        actual == expected

        where:
        S                      || expected
        "ab-cd"                || "dc-ba"
        "a-bC-dEf-ghIj"        || "j-Ih-gfE-dCba"
        "Test1ng-Leet=code-Q!" || "Qedo1ct-eeLg=ntse-T!"
    }
}
