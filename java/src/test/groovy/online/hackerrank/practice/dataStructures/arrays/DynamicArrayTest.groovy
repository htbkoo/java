package online.hackerrank.practice.dataStructures.arrays

import spock.lang.Specification

class DynamicArrayTest extends Specification {

    def "should append new number to seqList"() {
        given:
        def n = 2
        def queries = [
                [1, 0, 5],
                [1, 1, 7],
                [1, 0, 3],
                [2, 1, 0],
                [2, 1, 1],
        ]

        when:
        def answers = DynamicArray.Solution.dynamicArray(n, queries)

        then:
        answers == [7, 3]
    }

}
