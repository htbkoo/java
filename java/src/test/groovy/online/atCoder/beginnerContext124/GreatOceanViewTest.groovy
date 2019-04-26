package online.atCoder.beginnerContext124

import spock.lang.Specification
import spock.lang.Unroll

class GreatOceanViewTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = GreatOceanView.process(A, H)

        then:
        result == expected

        where:
        A | H               || expected
        4 | [6, 5, 6, 8]    || "3"
        5 | [4, 5, 3, 5, 4] || "3"
        5 | [9, 5, 6, 8, 4] || "1"
    }
}
