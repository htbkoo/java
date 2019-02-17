package online.hackerrank.practice.dataStructures.arrays

import spock.lang.Specification

class AppendQueryTest extends Specification {
    def "should append new number to seqList"() {
        given:
        DynamicArrayState state0 = DynamicArrayState.initialState(2);

        when:
        def state1 = new AppendQuery(0, 5).update(state0)

        then:
        state1.answers == []
        state1.lastAnswer == 0
        state1.seqLists == [[5], []]

        and:
        def state2 = new AppendQuery(1, 7).update(state1)

        then:
        state2.answers == []
        state2.lastAnswer == 0
        state2.seqLists == [[5], [7]]

        and:
        def state3 = new AppendQuery(0, 3).update(state2)

        then:
        state3.answers == []
        state3.lastAnswer == 0
        state3.seqLists == [[5, 3], [7]]

    }
}
