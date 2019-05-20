package online.atCoder.beginnerContext126

import spock.lang.Specification
import spock.lang.Unroll
import static spock.util.matcher.HamcrestMatchers.closeTo
import static spock.util.matcher.HamcrestSupport.that

class DiceAndCoinTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def result = DiceAndCoin.process(N, K)

        then:
        that Double.valueOf(result), closeTo(Double.valueOf(expected), 1E-8d)

        where:
        N      | K  || expected
        1      | 1  || "1.000000000000"
        3      | 10 || "0.145833333333"
        100000 | 5  || "0.999973749998"
    }
}
