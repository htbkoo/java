package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class TheTimeInWordsTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = TheTimeInWords.Solution.timeInWords(h, m)

        then:
        actual == expected

        where:
        h | m  || expected
        5 | 47 || "thirteen minutes to six"
        3 | 0  || "three o' clock"
        7 | 15 || "quarter past seven"

        5 | 0  || "five o' clock"
        5 | 1  || "one minute past five"
        5 | 10 || "ten minutes past five"
        5 | 15 || "quarter past five"
        5 | 30 || "half past five"
        5 | 40 || "twenty minutes to six"
        5 | 45 || "quarter to six"
        5 | 47 || "thirteen minutes to six"
        5 | 28 || "twenty eight minutes past five"

        5 | 59 || "one minute to six"

    }

    @Unroll
    def "intToWord(#i)"() {
        when:
        def word = TheTimeInWords.Solution.intToWord(i)

        then:
        word == expected

        where:
        i  || expected
        1  || "one"
        2  || "two"
        10 || "ten"
        20 || "twenty"
        13 || "thirteen"
        28 || "twenty eight"

    }
}
