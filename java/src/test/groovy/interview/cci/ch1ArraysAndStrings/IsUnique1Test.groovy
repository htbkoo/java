package interview.cci.ch1ArraysAndStrings

import spock.lang.Specification
import spock.lang.Unroll

abstract class IsUnique1TestBase extends Specification {
    @Unroll
    def "should test if given string has all unique characters"() {
        when:
        def actual = isUnique(s)

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

    abstract boolean isUnique(String s)
}

class IsUniqueTest extends IsUnique1TestBase {

    @Override
    boolean isUnique(String s) {
        IsUnique1.isUnique(s)
    }
}

class IsUniqueWithoutAdditionDataStructureTest extends IsUnique1TestBase {

    @Override
    boolean isUnique(String s) {
        IsUnique1.isUniqueWithoutAdditionDataStructure(s)
    }
}
