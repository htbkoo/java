package online.hackerrank.interviewPreparationKit.warmUpChallenges

import spock.lang.Specification
import spock.lang.Unroll

class TimeConversionTest extends Specification {
    @Unroll
    def "should return the total number of matching pairs of socks that John can sell"() {
        when:
        def actual = TimeConversion.Solution.timeConversion(s)

        then:
        actual == expectedPair

        where:
        s            || expectedPair
        "07:05:45PM" || "19:05:45"
        "12:40:22AM" || "00:40:22"
        "12:00:00AM" || "00:00:00"
        "12:00:00PM" || "12:00:00"
    }
}
