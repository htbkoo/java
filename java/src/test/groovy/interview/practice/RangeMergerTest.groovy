package interview.practice

import spock.lang.Specification
import spock.lang.Unroll

class RangeMergerTest extends Specification {
    @Unroll
    def "should manage ranges"() {
        given:
        def ids = [1]
        def merger = new RangeMerger()

        when:
        ids.each {
            merger.put(it)
            merger.contains(it)
        }

        then:
        def expectedSize = 1
        ids.every { merger.contains(it) }
        merger.size() == expectedSize
    }
}
