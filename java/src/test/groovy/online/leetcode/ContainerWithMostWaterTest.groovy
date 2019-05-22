package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class ContainerWithMostWaterTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new ContainerWithMostWater.Solution().maxArea(height as int[])

        then:
        actual == expected

        where:
        height                      || expected
        [1, 8, 6, 2, 5, 4, 8, 3, 7] || 49
    }
}
