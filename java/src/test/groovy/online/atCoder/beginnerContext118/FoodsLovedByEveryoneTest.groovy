package online.atCoder.beginnerContext118

import spock.lang.Specification
import spock.lang.Unroll

import static online.atCoder.beginnerContext118.FoodsLovedByEveryone.findNumber

class FoodsLovedByEveryoneTest extends Specification {
    @Unroll
    def "should find the number"() {
        given:
        def testCase = new FoodsLovedByEveryone.TestCase(N, M, A)

        when:
        def number = findNumber(testCase)

        then:
        number == expected

        where:
        N || M  || A                                                                                      || expected
        3 || 4  || [[1, 3], [1, 2, 3], [3, 2]]                                                            || 1
        5 || 5  || [[4, 2, 3, 4, 5], [4, 1, 3, 4, 5], [4, 1, 2, 4, 5], [4, 1, 2, 3, 5], [4, 1, 2, 3, 4],] || 0
        1 || 30 || [[5, 10, 30]]                                                                          || 3

    }
}
