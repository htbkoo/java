package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class MinimumIndexSumOfTwoListsTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = new MinimumIndexSumOfTwoLists.Solution().findRestaurant(list1 as String[], list2 as String[])

        then:
        actual == expected as String[]

        where:
        list1                                               | list2                                                                         || expected
        ["Shogun", "Tapioca Express", "Burger King", "KFC"] | ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"] || ["Shogun"]
        ["Shogun", "Tapioca Express", "Burger King", "KFC"] | ["KFC", "Shogun", "Burger King"]                                              || ["Shogun"]
    }

}
