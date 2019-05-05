package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class MedianOfTwoSortedArraysTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new MedianOfTwoSortedArrays.Solution().findMedianSortedArrays(nums1 as int[], nums2 as int[],)

        then:
        actual == expected

        where:
        nums1   | nums2  || expected
        [1, 3,] | [2]    || 2.0d
        [1, 2,] | [3, 4] || 2.5d
    }
}
