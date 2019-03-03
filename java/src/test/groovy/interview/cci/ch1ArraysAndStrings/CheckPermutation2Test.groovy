package interview.cci.ch1ArraysAndStrings

import spock.lang.Specification
import spock.lang.Unroll

class CheckPermutation2Test extends Specification {
    @Unroll
    def "should test if given string is permutation of another string"() {
        when:
        def actual = CheckPermutation2.arePermutation(s1, s2)

        then:
        actual == expected

        where:
        s1       || s2       || expected
        ""       || ""       || true
        "a"      || "a"      || true
        "ab"     || "ab"     || true
        "ab"     || "ba"     || true
        "Unique" || "nUqeui" || true
        "aa"     || "ab"     || false
        "aa"     || ""       || false
        "aa"     || "a"      || false
        "aa"     || "b"      || false
    }
}
