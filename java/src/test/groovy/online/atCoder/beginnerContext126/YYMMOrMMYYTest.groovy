package online.atCoder.beginnerContext126


import spock.lang.Specification
import spock.lang.Unroll

class YYMMOrMMYYTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def result = YYMMOrMMYY.process(S)

        then:
        result == expected

        where:
        S      || expected
        "1905" || "YYMM"
        "0112" || "AMBIGUOUS"
        "1700" || "NA"
    }
}
