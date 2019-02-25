package online.atCoder.beginnerContext119

import spock.lang.Specification
import spock.lang.Unroll

class DigitalGiftsTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = DigitalGifts.process(new DigitalGifts.TestCase(N, x, u))

        then:
        new BigDecimal(result) == new BigDecimal(expected)

        where:
        N || x                                                                                            || u                      || expected
        2 || [new BigDecimal("10000"), new BigDecimal("0.10000000"),]                                     || ["JPY", "BTC"]         || "48000.0"
        3 || [new BigDecimal("100000000"), new BigDecimal("100.00000000"), new BigDecimal("0.00000001"),] || ["JPY", "BTC", "BTC",] || "138000000.0038"
    }
}
