package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class BinarySearchTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new BinarySearch.Solution().search(nums as int[], target)

        then:
        actual == expected

        where:
        nums                 | target || expected
        [-1, 0, 3, 5, 9, 12] | 9      || 4
        [-1, 0, 3, 5, 9, 12] | 2      || -1
    }
}
