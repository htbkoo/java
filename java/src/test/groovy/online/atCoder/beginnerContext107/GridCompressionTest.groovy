package online.atCoder.beginnerContext107

import spock.lang.Specification
import spock.lang.Unroll

class GridCompressionTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = GridCompression.process(H, W, a)

        then:
        actual == expected

        where:
        H || W || a                                                                       || expected
        4 || 4 || ["##.#", "....", "##.#", ".#.#",]                                       || ["###", "###", ".##",]
        3 || 3 || ["#..", ".#.", "..#",]                                                  || ["#..", ".#.", "..#",]
        4 || 5 || [".....", ".....", "..#..", ".....",]                                   || ["#"]
        7 || 6 || ["......", "....#.", ".#....", "..#...", "..#...", "......", ".#..#.",] || ["..#", "#..", ".#.", ".#.", "#.#",]
    }
}
