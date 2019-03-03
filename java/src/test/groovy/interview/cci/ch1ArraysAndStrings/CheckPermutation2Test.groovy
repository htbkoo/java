package interview.cci.ch1ArraysAndStrings

import spock.lang.Specification
import spock.lang.Unroll

abstract class CheckPermutation2TestBase extends Specification {
    @Unroll
    def "should test if given string is permutation of another string"() {
        when:
        def actual = arePermutation(s1, s2)

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

    abstract boolean arePermutation(String s1, String s2)
}

class ArePermutationTest extends CheckPermutation2TestBase {

    @Override
    boolean arePermutation(String s1, String s2) {
        CheckPermutation2.arePermutation(s1, s2)
    }
}

class ArePermutationBySortTest extends CheckPermutation2TestBase {

    @Override
    boolean arePermutation(String s1, String s2) {
        CheckPermutation2.arePermutationBySort(s1, s2)
    }
}
