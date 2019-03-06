package online.atCoder.beginnerContext111

import spock.lang.Specification
import spock.lang.Unroll

class AtCoderBeginnerContest111Test extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = AtCoderBeginnerContest111.process(new AtCoderBeginnerContest111.TestCase(N))

        then:
        result == expected

        where:
        N   || expected
        111 || "111"
        112 || "222"
        750 || "777"
    }
}
