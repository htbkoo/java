package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class CourseScheduleTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new CourseSchedule.Solution().canFinish(numCourses, prerequisites as int[][])

        then:
        actual == expected

        where:
        numCourses | prerequisites                                    || expected
        2          | [[1, 0]]                                         || true
        2          | [[1, 0], [0, 1]]                                 || false
        5          | [[1, 0], [2, 0], [3, 0], [4, 0], [2, 1]]         || true
        5          | [[1, 0], [2, 0], [3, 0], [3, 2], [2, 1], [1, 3]] || false
    }
}
