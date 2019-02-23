package online.atCoder.beginnerContext116

import spock.lang.Specification
import spock.lang.Unroll

class CollatzProblemTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = CollatzProblem.process(new CollatzProblem.TestCase(s))

        then:
        result == expected

        where:
        s  || expected
        8  || 5
        7  || 18
        54 || 114
    }
}