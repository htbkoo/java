package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class FindCommonCharactersTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new FindCommonCharacters.Solution().commonChars(A as String[])

        then:
        actual == expected

        where:
        A                            || expected
        ["bella", "label", "roller"] || ["e", "l", "l"]
        ["cool", "lock", "cook"]     || ["c", "o"]
    }
}
