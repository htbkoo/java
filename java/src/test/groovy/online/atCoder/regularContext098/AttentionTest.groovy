package online.atCoder.regularContext098

import spock.lang.Specification
import spock.lang.Unroll

class AttentionTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = Attention.process(new Attention.TestCase(N, S))

        then:
        result == expected

        where:
        N  || S              || expected
        5  || "WEEWW"        || "1"
        12 || "WEWEWEEEWWWE" || "4"
        8  || "WWWWWEEE"     || "3"
    }
}
