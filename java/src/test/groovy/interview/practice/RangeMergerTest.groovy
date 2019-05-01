package interview.practice

import spock.lang.Specification
import spock.lang.Unroll

class RangeMergerTest extends Specification {
    @Unroll
    def "should manage ranges"() {
        when:
        def merger = new RangeMerger()

        then:
        operations.each {
            merger.put(it.id)
            assert merger.contains(it.id)
            assert merger.size() == it.expectedSize
        }

        where:
        operations << [
                [op(1, 1),],
                [op(1, 1), op(2, 1),],
                [op(1, 1), op(3, 2),],
                [op(1, 1), op(3, 2), op(2, 1)],
                [op(1, 1), op(3, 2), op(4, 2), op(2, 1)],
        ]
    }

    def op(int id, int size) {
        [id: id, expectedSize: size]
    }
}
