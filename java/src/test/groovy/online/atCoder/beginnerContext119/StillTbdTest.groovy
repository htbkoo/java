package online.atCoder.beginnerContext119

import spock.lang.Specification
import spock.lang.Unroll

class StillTbdTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = StillTbd.process(new StillTbd.TestCase(S))

        then:
        result == expected

        where:
        S            || expected
        "2019/04/30" || "Heisei"
        "2019/11/01" || "TBD"
    }
}
