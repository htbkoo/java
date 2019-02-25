package online.atCoder.beginnerContext115

import spock.lang.Specification
import spock.lang.Unroll

class ChristmasTest extends Specification {

    @Unroll
    def "should find"() {
        when:
        def result = Christmas.process(new Christmas.TestCase(N, X))

        then:
        result == expected

        where:
        N  || X                || expected
        2  || 7                || 4L
        1  || 1                || 0L
        50 || 4321098765432109 || 2160549382716056L
        50 || 2147483647       || 0L
    }

}
