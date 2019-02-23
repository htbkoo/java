package online.atCoder.beginnerContext116

import spock.lang.Specification
import spock.lang.Unroll

class GrandGardenTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = GrandGarden.process(new GrandGarden.TestCase(N, h))

        then:
        result == expected

        where:
        N || h                               || expected
        4 || [1, 2, 2, 1]                    || 2
        5 || [3, 1, 2, 3, 1]                 || 5
        8 || [4, 23, 75, 0, 23, 96, 50, 100] || 221
    }
}