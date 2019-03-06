package online.atCoder.beginnerContext111

import spock.lang.Specification
import spock.lang.Unroll

class AtCoderBeginnerContest999Test extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = AtCoderBeginnerContest999.process(new AtCoderBeginnerContest999.TestCase(N))

        then:
        result == expected

        where:
        N   || expected
        119 || "991"
        999 || "111"
    }
}
