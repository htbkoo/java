package online.atCoder.beginnerContext124

import spock.lang.Specification
import spock.lang.Unroll

class ColoringColorfullyTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = ColoringColorfully.process(S)

        then:
        result == expected

        where:
        S          || expected
        "000"      || "1"
        "10010010" || "3"
        "0"        || "0"
    }
}
