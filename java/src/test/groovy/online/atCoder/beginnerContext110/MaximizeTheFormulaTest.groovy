package online.atCoder.beginnerContext110


import spock.lang.Specification
import spock.lang.Unroll

class MaximizeTheFormulaTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = MaximizeTheFormula.process(new MaximizeTheFormula.TestCase(A, B, C))

        then:
        result == expected

        where:
        A || B || C || expected
        1 || 5 || 2 || "53"
        9 || 9 || 9 || "108"
        6 || 6 || 7 || "82"
    }
}
