package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class FindSmallestLetterGreaterThanTargetTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new FindSmallestLetterGreaterThanTarget.Solution().nextGreatestLetter(letters as char[], target as char)

        then:
        actual == expected as char

        where:
        letters                                 | target || expected
        ['c' as char, 'f' as char, 'j' as char] | 'a'    || 'c'
        ['c' as char, 'f' as char, 'j' as char] | 'c'    || 'f'
        ['c' as char, 'f' as char, 'j' as char] | 'd'    || 'f'
        ['c' as char, 'f' as char, 'j' as char] | 'g'    || 'j'
        ['c' as char, 'f' as char, 'j' as char] | 'j'    || 'c'
        ['c' as char, 'f' as char, 'j' as char] | 'k'    || 'c'
    }
}
