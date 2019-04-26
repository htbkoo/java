package interview.cci.ch8RecursionAndDynamicProgramming

import spock.lang.Specification
import spock.lang.Unroll

import static java.util.Optional.empty
import static java.util.Optional.of

class MagicIndex3Test extends Specification {
    @Unroll
    def "should find magic index if present"() {
        when:
        def magicIndex = new MagicIndex3().findMagicIndex(A as int[])

        then:
        magicIndex == expected

//        TODO: fix all tests
        where:
        A                           || expected
//        [] || empty()
        [1]                         || empty()
        [0]                         || of(0)
        [1, 2, 3, 4, 5]             || empty()
        [1, 3, 5]                   || empty()
        [-5, 3, 7]                  || empty()
        [-5, -4, -3]                || empty()
        [-5, -3, -1, 1, 3, 5]       || of(5)
        [-5, -3, -1, 1, 3, 5, 7, 9] || of(5)

    }
}
