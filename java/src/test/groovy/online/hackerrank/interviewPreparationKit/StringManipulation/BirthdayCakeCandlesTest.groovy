package online.hackerrank.interviewPreparationKit.StringManipulation

import spock.lang.Specification
import spock.lang.Unroll

class BirthdayCakeCandlesTest extends Specification {

    @Unroll
    def "It should print the minimum number of deletions required on a new line"() {
        when:
        def actual = BirthdayCakeCandles.Solution.birthdayCakeCandles(ar as int[])

        then:
        actual == expected

        where:
        ar                       || expected
        [4, 4, 5, 4, 4, 4, 1, 3] || 1
        [4, 4, 4, 4, 4, 1, 3]    || 5
        [4, 4, 1, 3]             || 2
        [3, 2, 1, 3]             || 2
        [1]                      || 1
    }

}
