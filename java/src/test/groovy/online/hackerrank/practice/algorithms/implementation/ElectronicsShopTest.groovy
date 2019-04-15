package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class ElectronicsShopTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = ElectronicsShop.Solution.getMoneySpent(keyboards as int[], drives as int[], b)

        then:
        actual == expected

        where:
        keyboards    | drives     | b  || expected
        [40, 50, 60] | [5, 8, 12] | 60 || 58
        [3, 1]       | [5, 2, 8]  | 10 || 9
        [4]          | [5]        | 5  || -1
    }
}
