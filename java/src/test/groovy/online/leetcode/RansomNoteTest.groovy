package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class RansomNoteTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def num = new RansomNote.Solution().canConstruct(ransomNote, magazine)

        then:
        num == expected

        where:
        ransomNote | magazine || expected
        "a"        | "b"      || false
        "aa"       | "ab"     || false
        "aa"       | "aab"    || true
    }
}
