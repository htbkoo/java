package online.atCoder.beginnerContext113

import spock.lang.Specification
import spock.lang.Unroll

class IDTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = ID.process(new ID.TestCase(N, M, P, Y))

        then:
        result == expected

        where:
        N      || M || P                     || Y                        || expected
        2      || 3 || [1, 2, 1]             || [32, 63, 12]             || ["000001000002", "000002000001", "000001000001"]
        2      || 3 || [2, 2, 2]             || [55, 77, 99]             || ["000002000001", "000002000002", "000002000003",]
        100000 || 7 || [2, 2, 2, 2, 2, 2, 2] || [55, 77, 99, 1, 5, 2, 3] || ["000002000005", "000002000006", "000002000007", "000002000001", "000002000004", "000002000002", "000002000003",]
    }

}
