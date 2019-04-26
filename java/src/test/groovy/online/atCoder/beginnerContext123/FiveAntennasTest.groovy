package online.atCoder.beginnerContext123


import spock.lang.Specification
import spock.lang.Unroll

class FiveAntennasTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = FiveAntennas.process(a, b, c, d, e, k)

        then:
        result == expected

        where:
        a  | b  | c  | d  | e  | k  || expected
        1  | 2  | 4  | 8  | 9  | 15 || "Yay!"
        15 | 18 | 26 | 35 | 36 | 18 || ":("
    }
}
