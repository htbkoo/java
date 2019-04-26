package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class BeautifulDaysAtTheMoviesTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = BeautifulDaysAtTheMovies.Solution.beautifulDays(i, j, k)

        then:
        actual == expected

        where:
        i  | j  | k || expected
        20 | 23 | 6 || 2
    }
}
