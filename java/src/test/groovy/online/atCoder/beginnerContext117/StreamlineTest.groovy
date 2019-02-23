package online.atCoder.beginnerContext117

import online.atCoder.beginnerContext119.Streamline
import spock.lang.Specification
import spock.lang.Unroll

class StreamlineTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = Streamline.process(new Streamline.TestCase(N, M, X))

        then:
        result == expected

        where:
        N   || M || X                            || expected
        2   || 5 || [10, 12, 1, 2, 14]           || 5
        3   || 7 || [-10, -3, 0, 9, -100, 2, 17] || 19
        100 || 1 || [-100000]                    || 0
    }
}