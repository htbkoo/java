package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class IntersectionOfTwoArraysIITest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new IntersectionOfTwoArraysII.Solution().intersect(nums1 as int[], nums2 as int[],)

        then:
        actual == expected as int[]

        where:
        nums1        | nums2           || expected
        [1, 2, 2, 1] | [2, 2]          || [2, 2]
        [4, 9, 5]    | [9, 4, 9, 8, 4] || [4, 9]
    }
}
