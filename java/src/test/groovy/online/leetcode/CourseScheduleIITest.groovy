package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class CourseScheduleIITest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new CourseScheduleII.Solution().findOrder(numCourses, prerequisites as int[][])

        then:
        actual == expected as int[]

        where:
        numCourses | prerequisites                                    || expected
        2          | [[1, 0]]                                         || [0, 1]
        2          | [[1, 0], [0, 1]]                                 || []
        5          | [[1, 0], [2, 0], [3, 0], [4, 0], [2, 1]]         || [0, 1, 3, 4, 2]
        5          | [[1, 0], [2, 0], [3, 0], [3, 2], [2, 1], [1, 3]] || []

        4          | [[1, 0], [2, 0], [3, 1], [3, 2]]                 || [0, 1, 2, 3]
    }
}
