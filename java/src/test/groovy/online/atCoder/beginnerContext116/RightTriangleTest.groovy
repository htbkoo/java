package online.atCoder.beginnerContext116


import spock.lang.Specification
import spock.lang.Unroll

class RightTriangleTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = RightTriangle.process(new RightTriangle.TestCase(AB, BC, CA))

        then:
        result == expected

        where:
        AB || BC || CA || expected
        3  || 4  || 5  || 6
        5  || 12 || 13 || 30
        45 || 28 || 53 || 630
    }
}