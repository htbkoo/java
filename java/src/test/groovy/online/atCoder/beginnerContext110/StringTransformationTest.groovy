package online.atCoder.beginnerContext110

import spock.lang.Specification
import spock.lang.Unroll

class StringTransformationTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = StringTransformation.process(new StringTransformation.TestCase(S, T))

        then:
        result == expected

        where:
        S                            || T                            || expected
        "chokudai"                   || "redcoder"                   || "No"
        "azzel"                      || "apple"                      || "Yes"
        "abcdefghijklmnopqrstuvwxyz" || "ibyhqfrekavclxjstdwgpzmonu" || "Yes"
    }
}
