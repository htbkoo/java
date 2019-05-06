package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class SearchInRotatedSortedArrayTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new SearchInRotatedSortedArray.Solution().search(nums as int[], target)

        then:
        actual == expected

        where:
        nums                  | target || expected
        [4, 5, 6, 7, 0, 1, 2] | 0      || 4
        [4, 5, 6, 7, 0, 1, 2] | 3      || -1
        [4, 3, 4, 4, 4]       | 3      || 1
        [4, 4, 4, 3, 4]       | 3      || 3
        [4, 3, 4, 4, 4]       | 2      || -1
        [4, 4, 4, 3, 4]       | 2      || -1

    }
}
