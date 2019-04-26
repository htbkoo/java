package online.atCoder.beginnerContext123

import spock.lang.Specification
import spock.lang.Unroll

class FiveDishesTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = FiveDishes.process(a, b, c, d, e)

        then:
        result == expected

        where:
        a   | b   | c   | d   | e   || expected
        29  | 20  | 7   | 35  | 120 || "215"
        101 | 86  | 119 | 108 | 57  || "481"
        123 | 123 | 123 | 123 | 123 || "643"
    }
}
