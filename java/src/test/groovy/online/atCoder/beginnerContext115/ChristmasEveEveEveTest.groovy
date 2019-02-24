package online.atCoder.beginnerContext115

import spock.lang.Specification
import spock.lang.Unroll

class ChristmasEveEveEveTest extends Specification {

    @Unroll
    def "should find"() {
        when:
        def result = ChristmasEveEveEve.process(new ChristmasEveEveEve.TestCase(D))

        then:
        result == expected

        where:
        D  || expected
        22 || "Christmas Eve Eve Eve"
        23 || "Christmas Eve Eve"
        24 || "Christmas Eve"
        25 || "Christmas"
    }

}
