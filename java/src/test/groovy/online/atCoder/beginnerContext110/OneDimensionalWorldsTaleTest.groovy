package online.atCoder.beginnerContext110

import spock.lang.Specification
import spock.lang.Unroll

class OneDimensionalWorldsTaleTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = OneDimensionalWorldsTale.process(new OneDimensionalWorldsTale.TestCase(N, M, X, Y, x, y))

        then:
        result == expected

        where:
        N || M || X   || Y  || x                    || y            || expected
        3 || 2 || 10  || 20 || [8, 15, 13]          || [16, 22]     || "No War"
        4 || 2 || -48 || -1 || [-20, -35, -91, -23] || [-22, 66,]   || "War"
        5 || 3 || 6   || 8  || [-10, 3, 1, 5, -100] || [100, 6, 14] || "War"
    }
}
