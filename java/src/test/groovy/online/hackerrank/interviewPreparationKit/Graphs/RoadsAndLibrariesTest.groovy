package online.hackerrank.interviewPreparationKit.Graphs

import spock.lang.Specification
import spock.lang.Unroll

class RoadsAndLibrariesTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = RoadsAndLibraries.Solution.roadsAndLibraries(n, c_lib, c_road, cities as int[][])

        then:
        actual == expected

        where:
        n | c_lib | c_road | cities || expected
        3 | 2     | 1      |
                [[1, 2],
                 [3, 1],
                 [2, 3],]           || 4
        6 | 2     | 1      |
                [[1, 3],
                 [3, 4],
                 [2, 4],
                 [1, 2],
                 [2, 3],
                 [5, 6],]           || 8
        6 | 2     | 5      |
                [[1, 3],
                 [3, 4],
                 [2, 4],
                 [1, 2],
                 [2, 3],
                 [5, 6],]           || 12
    }
}
