package interview.practice

import spock.lang.Specification
import spock.lang.Unroll

class RangeMergerTest extends Specification {
    @Unroll
    def "should manage ranges"() {
        given:
        def merger = new RangeMerger()

        when:
        merger.put(1)

        then:
        merger.contains(1)
        merger.size() == 1


    }
}
