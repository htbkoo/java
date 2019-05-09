package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

import static java.util.stream.Collectors.toList

class MinesweeperTest extends Specification {

    @Unroll
    def "test"() {
        when:
        char[][] actual = new Minesweeper.Solution().updateBoard(board as char[][], input as int[])
        List<List<String>> actualList = Arrays.stream(actual)
                .map { Arrays.stream(new String(it).split("")).collect(toList()) }
                .collect(toList())

        then:
        actualList == expected

        where:
        board                       | input  || expected
        [['E', 'E', 'E', 'E', 'E'],
         ['E', 'E', 'M', 'E', 'E'],
         ['E', 'E', 'E', 'E', 'E'],
         ['E', 'E', 'E', 'E', 'E']] | [3, 0] || [['B', '1', 'E', '1', 'B'],
                                                 ['B', '1', 'M', '1', 'B'],
                                                 ['B', '1', '1', '1', 'B'],
                                                 ['B', 'B', 'B', 'B', 'B']]


        [['B', '1', 'E', '1', 'B'],
         ['B', '1', 'M', '1', 'B'],
         ['B', '1', '1', '1', 'B'],
         ['B', 'B', 'B', 'B', 'B']] | [1, 2] || [['B', '1', 'E', '1', 'B'],
                                                 ['B', '1', 'X', '1', 'B'],
                                                 ['B', '1', '1', '1', 'B'],
                                                 ['B', 'B', 'B', 'B', 'B']]
    }
}
