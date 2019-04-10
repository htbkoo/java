package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class GradingStudentsTest extends Specification {
    @Unroll
    def "should return the total number of matching pairs of socks that John can sell"() {
        when:
        def actual = GradingStudents.Solution.gradingStudents(grades as int[])

        then:
        actual == expected as int[]

        where:
        grades           || expected
        [73, 67, 38, 33] || [75, 67, 40, 33]

    }
}
