package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class RemoveOutermostParenthesesTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new RemoveOutermostParentheses.Solution().removeOuterParentheses(S)

        then:
        actual == expected

        where:
        S                    || expected
        "(()())(())"         || "()()()"
        "(()())(())(()(()))" || "()()()()(())"
        "()()"               || ""
    }
}
