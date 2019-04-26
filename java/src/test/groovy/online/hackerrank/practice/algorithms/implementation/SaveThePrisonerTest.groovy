package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class SaveThePrisonerTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = SaveThePrisoner.Solution.saveThePrisoner(n, m, s)

        then:
        actual == expected

        where:
        n         | m         | s || expected
        5         | 2         | 1 || 2
        5         | 2         | 2 || 3

        7         | 19        | 2 || 6
        3         | 7         | 3 || 3

        999999999 | 999999999 | 2 || 1
    }
}
