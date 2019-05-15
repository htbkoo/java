package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class LibraryFineTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = LibraryFine.Solution.libraryFine(d1, m1, y1, d2, m2, y2,)

        then:
        actual == expected

        where:
        d1 | m1 | y1   | d2 | m2 | y2   || expected
        9  | 6  | 2015 | 6  | 6  | 2015 || 45

        1  | 1  | 2017 | 1  | 1  | 2018 || 0
        1  | 1  | 2017 | 1  | 1  | 2017 || 0
        1  | 1  | 2017 | 2  | 1  | 2017 || 0

        2  | 1  | 2017 | 1  | 1  | 2017 || 15

        1  | 1  | 2018 | 1  | 1  | 2017 || 10000
        1  | 1  | 2018 | 31 | 12 | 2017 || 10000

    }
}
