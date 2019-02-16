package online.hackerrank.interviewPreparationKit.warmUpChallenges

import spock.lang.Specification
import spock.lang.Unroll

class RepeatedStringTest extends Specification {
    @Unroll
    def "it should print a single integer denoting the number of letter a's in the first letters of the infinite string created by repeating infinitely many times"() {
        when:
        def actual = RepeatedString.Solution.repeatedString(s, n)

        then:
        actual == expected

        where:
        s     || n             || expected
        "aba" || 10            || 7
        "a"   || 1000000000000 || 1000000000000
    }
}
