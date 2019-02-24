package online.atCoder.beginnerContext115

import spock.lang.Specification
import spock.lang.Unroll

class ChristmasEveEveTest extends Specification {

    @Unroll
    def "should find"() {
        when:
        def result = ChristmasEveEve.process(new ChristmasEveEve.TestCase(N, p))

        then:
        result == expected

        where:
        N || p                        || expected
        3 || [4980, 7980, 6980,]      || 15950
        4 || [4320, 4320, 4320, 4320] || 15120

    }

}
