package online.hackerrank.interviewPreparationKit.warmUpChallenges

import spock.lang.Specification
import spock.lang.Unroll

class CountingValleysTest extends Specification {
    @Unroll
    def "it should print a single integer that denotes the number of valleys Gary walked through during his hike"() {
        when:
        def actual = CountingValleys.Solution.countingValleys(n, s)

        then:
        actual == expected

        where:
        n || s          || expected
        8 || "UDDDUDUU" || 1
        2 || "DU"       || 1
        2 || "UD"       || 0
        4 || "UDUD"     || 0
        4 || "DUDU"     || 2
        8 || "DDUUUUDD" || 1
        8 || "DDUDUDDD" || 0
        8 || "DDUDUDUU" || 1
    }
}
