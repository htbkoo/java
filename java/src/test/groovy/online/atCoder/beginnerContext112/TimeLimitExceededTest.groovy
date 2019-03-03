package online.atCoder.beginnerContext112

import spock.lang.Specification
import spock.lang.Unroll

import static online.atCoder.beginnerContext112.TimeLimitExceeded.TestCase
import static online.atCoder.beginnerContext112.TimeLimitExceeded.process

class TimeLimitExceededTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = process(new TestCase(N, T, c, t))

        then:
        result == expected

        where:
        N || T  || c                    || t                     || expected
        3 || 70 || [7, 1, 4,]           || [60, 80, 50,]         || "4"
        4 || 3  || [1, 2, 3, 4,]        || [1000, 4, 1000, 500,] || "TLE"
        5 || 9  || [25, 5, 4, 1000, 6,] || [8, 9, 10, 1000, 1,]  || "5"
    }

}
