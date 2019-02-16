package online.hackerrank.interviewPreparationKit.warmUpChallenges

import spock.lang.Specification
import spock.lang.Unroll

class SockMerchantTest extends Specification {
    @Unroll
    def "should return the total number of matching pairs of socks that John can sell"() {
        when:
        def actual = SockMerchant.Solution.sockMerchant(n, ar as int[])

        then:
        actual == expectedPair

        where:
        n  || ar                                   || expectedPair
        7  || [1, 2, 1, 2, 1, 3, 2]                || 2
        9  || [10, 20, 20, 10, 10, 30, 50, 10, 20] || 3
        10 || [1, 1, 3, 1, 2, 1, 3, 3, 3, 3]       || 4
    }
}
