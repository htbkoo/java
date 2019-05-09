package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

import static java.util.stream.Collectors.toList
import static java.util.stream.Collectors.toSet

class KClosestPointsToOriginTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new KClosestPointsToOrigin.Solution().kClosest(points as int[][], K)
        Set<List<Integer>> actualList = Arrays.stream(actual).map { array -> Arrays.stream(array).boxed().collect(toList()) }
                .collect(toSet())

        then:
        actualList == new HashSet<>(expected)

        where:
        points                                                | K || expected
//        [[1, 3] as int[], [-2, 2] as int[]]                   | 1 || [[-2, 2] as int[]] as int[][]
//        [[3, 3] as int[], [5, -1] as int[], [-2, 4] as int[]] | 2 || [[3, 3] as int[], [-2, 4] as int[]] as int[][]
        [[1, 3] as int[], [-2, 2] as int[]]                   | 1 || [[-2, 2]]
        [[3, 3] as int[], [5, -1] as int[], [-2, 4] as int[]] | 2 || [[3, 3], [-2, 4]]
    }
}
