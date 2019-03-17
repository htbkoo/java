package online.atCoder.beginnerContext107

import spock.lang.Specification
import spock.lang.Unroll

class TrainTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = Train.process(N,i)

        then:
        actual == expected

        where:
        N  || i  || expected
        4  || 2  || "3"
        1  || 1  || "1"
        15 || 11 || "5"
    }
}
