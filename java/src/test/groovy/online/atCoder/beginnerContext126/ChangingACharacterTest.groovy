package online.atCoder.beginnerContext126


import spock.lang.Specification
import spock.lang.Unroll

class ChangingACharacterTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def result = ChangingACharacter.process(N, K, S)

        then:
        result == expected

        where:
        N | K | S      || expected
        1 | 1 | "A"    || "a"

        3 | 1 | "ABC"  || "aBC"
        4 | 3 | "CABA" || "CAbA"
    }
}
