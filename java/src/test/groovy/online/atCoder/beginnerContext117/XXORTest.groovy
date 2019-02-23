package online.atCoder.beginnerContext117

import spock.lang.Specification
import spock.lang.Unroll

class XXORTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = XXOR.process(new XXOR.TestCase(N, K, A))

        then:
        result == expected

        where:
        N  || K  || A                || expected
        3L || 7L || [1L, 6L, 3L]     || 14L
        4L || 9L || [7L, 4L, 0L, 3L] || 46L
        1L || 0L || [1000000000000L] || 1000000000000L
    }
}