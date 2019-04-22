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
        9 | 91    | 84     |
                [[8, 2],
                 [2, 9],]           || 805
        5 | 92    | 23     |
                [[2, 1],
                 [5, 3],
                 [5, 1],
                 [3, 4],
                 [3, 1],
                 [5, 4],
                 [4, 1],
                 [5, 2],
                 [4, 2],]           || 184
        8 | 10    | 55     |
                [[6, 4],
                 [3, 2],
                 [7, 1],]           || 80
        1 | 5     | 3      |
                []                  || 5
        2 | 102   | 1      |
                []                  || 204
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

/*
Test Case 1:

input:
5
9 2 91 84
8 2
2 9
5 9 92 23
2 1
5 3
5 1
3 4
3 1
5 4
4 1
5 2
4 2
8 3 10 55
6 4
3 2
7 1
1 0 5 3
2 0 102 1

expected:
805
184
80
5
204
* */
