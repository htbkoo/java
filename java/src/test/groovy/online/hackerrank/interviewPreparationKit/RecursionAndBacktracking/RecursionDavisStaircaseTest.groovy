package online.hackerrank.interviewPreparationKit.RecursionAndBacktracking

import online.hackerrank.interviewPreparationKit.RecursionAndBacktracking.RecursionDavisStaircase
import spock.lang.Specification
import spock.lang.Unroll

class RecursionDavisStaircaseTest extends Specification {

    @Unroll
    def "It tests"() {
        when:
        def actual = RecursionDavisStaircase.Solution.stepPerms(n)

        then:
        actual == expected

        where:
        n  || expected
        1  || 1
        3  || 4
        5  || 13
        7  || 44
        8  || 81
        15 || 5768
        20 || 121415
        27 || 8646064


        35
        30
        33
        36
        20
        1132436852
        53798080
        334745777
        2082876103
        121415
    }

}
