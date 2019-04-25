package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class RangeAdditionIITest extends Specification {
    @Unroll
    def "test"() {
        when:
        def num = new RangeAdditionII.Solution().maxCount(m, n, ops as int[][])

        then:
        num == expected

        where:
        m  | n  | ops                                                                                                                           || expected
        3  | 3  | [[2, 2], [3, 3]]                                                                                                              || 4
        3  | 3  | []                                                                                                                            || 9
        26 | 17 | [[20, 10], [26, 11], [2, 11], [4, 16], [2, 3], [23, 13], [7, 15], [11, 11], [25, 13], [11, 13], [13, 11], [13, 16], [26, 17]] || 6
    }
}
