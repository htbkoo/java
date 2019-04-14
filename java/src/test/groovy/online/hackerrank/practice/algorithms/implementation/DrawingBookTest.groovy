package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class DrawingBookTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = DrawingBook.Solution.pageCount(n, p)

        then:
        actual == expected

        where:
        n | p || expected
        9 | 1 || 0
        9 | 2 || 1
        9 | 3 || 1
        9 | 4 || 2
        9 | 5 || 2
        9 | 6 || 1
        9 | 7 || 1
        9 | 8 || 0
        9 | 9 || 0
        8 | 1 || 0
        8 | 2 || 1
        8 | 3 || 1
        8 | 4 || 2
        8 | 5 || 2
        8 | 6 || 1
        8 | 7 || 1
        8 | 8 || 0
        6 | 2 || 1
        5 | 4 || 0
    }
}
