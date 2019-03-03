package online.atCoder.beginnerContext112

import spock.lang.Specification
import spock.lang.Unroll

class ProgrammingEducationTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = ProgrammingEducation.process(testCase)

        then:
        result == expected

        where:
        testCase                                   || expected
        new ProgrammingEducation.TestCase(1)       || "Hello World"
        new ProgrammingEducation.TestCase(2, 3, 5) || "8"
    }
}
