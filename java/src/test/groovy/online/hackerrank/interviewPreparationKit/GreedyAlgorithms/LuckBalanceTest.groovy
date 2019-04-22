package online.hackerrank.interviewPreparationKit.GreedyAlgorithms


import spock.lang.Specification
import spock.lang.Unroll

class LuckBalanceTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = LuckBalance.Solution.luckBalance(k, contest as int[][])

        then:
        actual == expected

        where:
        k | contest                                            || expected
        3 | [[5, 0], [1, 0], [4, 0],]                          || 10
        2 | [[5, 1], [1, 1], [4, 0],]                          || 10
        1 | [[5, 1], [1, 1], [4, 0],]                          || 8
        0 | [[5, 1], [1, 1], [4, 0],]                          || -2
        3 | [[5, 1], [2, 1], [1, 1], [8, 1], [10, 0], [5, 0],] || 29
    }

}
