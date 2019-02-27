package online.atCoder.regularContext103


import spock.lang.Specification
import spock.lang.Unroll

class CSequencesTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = CSequences.process(new CSequences.TestCase(n, v))

        then:
        new BigDecimal(result) == new BigDecimal(expected)

        where:
        n || v                              || expected
        6 || [2, 1, 2, 1, 3, 4]             || 2
        4 || [3, 1, 3, 2]                   || 1
        6 || [105, 119, 105, 119, 105, 119] || 0
        4 || [1, 1, 1, 1]                   || 2
        4 || [4, 5, 5, 4]                   || 2
        4 || [4, 4, 5, 4]                   || 1
        4 || [4, 4, 5, 5]                   || 2
        2 || [1, 1]                         || 1
        3 || [1, 1, 1]                      || 1
        3 || [1, 1, 2]                      || 1
        3 || [1, 2, 2]                      || 1
        3 || [1, 2, 3]                      || 1
        3 || [1, 2, 1]                      || 0
    }
}
