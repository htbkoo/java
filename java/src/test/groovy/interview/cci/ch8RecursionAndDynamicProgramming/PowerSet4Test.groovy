package interview.cci.ch8RecursionAndDynamicProgramming

import spock.lang.Specification
import spock.lang.Unroll

class PowerSet4Test extends Specification {
    @Unroll
    def "should find magic index if present"() {
        when:
        def allSubsets = new PowerSet4().findAllSubsets(list.toSet())

        then:
        allSubsets == (expected as List<List<Integer>>).collect { it.toSet() }.toSet()

        where:
        list         || expected
        []           || [[],]
        [1]          || [[], [1]]
        [0]          || [[], [0]]
        [0, 1]       || [[], [0], [1], [0, 1]]
        [1, 3, 5]    || [[], [1,], [3,], [5,], [1, 3], [3, 5], [1, 5,], [1, 3, 5]]
        [1, 2, 3, 4] || [[], [1,], [2,], [3,], [4,], [1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4], [1, 2, 3], [1, 2, 4], [1, 3, 4], [2, 3, 4], [1, 2, 3, 4]]
    }
}
