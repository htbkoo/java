package online.atCoder.beginnerContext117

import spock.lang.Specification
import spock.lang.Unroll

class EntranceExaminationTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = EntranceExamination.process(new EntranceExamination.TestCase(T, X))

        then:
        result == new BigDecimal(expected)

        where:
        T  || X   || expected
        8  || 3   || "2.6666666667"
        99 || 1   || "99.0000000000"
        1  || 100 || "0.0100000000"
    }
}