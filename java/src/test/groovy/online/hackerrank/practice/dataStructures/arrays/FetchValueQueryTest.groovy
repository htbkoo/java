package online.hackerrank.practice.dataStructures.arrays

import spock.lang.Specification

class FetchValueQueryTest extends Specification {
    def "should append new number to seqList"() {
        given:
        DynamicArrayState state0 = new DynamicArrayState([[5, 3], [7]], [], 0)

        when:
        def state1 = new FetchValueQuery(1, 0).update(state0)

        then:
        state1.answers == [7]
        state1.lastAnswer == 7
        state1.seqLists == [[5, 3], [7]]

        and:
        def state2 = new FetchValueQuery(1, 1).update(state1)

        then:
        state2.answers == [7, 3]
        state2.lastAnswer == 3
        state2.seqLists == [[5, 3], [7]]
    }
}
