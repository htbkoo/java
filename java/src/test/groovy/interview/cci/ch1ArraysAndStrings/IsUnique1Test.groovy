package interview.cci.ch1ArraysAndStrings

import spock.lang.Specification
import spock.lang.Unroll

class IsUnique1Test extends Specification {
    @Unroll
    def "should test if given string has all unique characters"() {
        when:
        def actual = IsUnique1.isUniqueWithoutAdditionDataStructure(s)

        then:
        actual == expected

        where:
        s            || expected
        ""           || true
        "a"          || true
        "ab"         || true
        "Unique"     || true
        "algorithm"  || true
        "aa"         || false
        "additional" || false
    }
}
