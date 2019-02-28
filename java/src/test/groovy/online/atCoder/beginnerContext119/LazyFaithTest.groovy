package online.atCoder.beginnerContext119

import spock.lang.Specification
import spock.lang.Unroll

import static java.util.Optional.empty
import static java.util.Optional.of

class LazyFaithTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = LazyFaith.process(new LazyFaith.TestCase(A, B, Q, s, t, x))

        then:
        result == expected

        where:
        A || B || Q || s            || t                   || x                              || expected
        1 || 1 || 3 || [1L]         || [10000000000L]      || [2L, 9999999999L, 5000000000L] || [10000000000L, 10000000000L, 14999999998L]
        2 || 3 || 4 || [100L, 600L] || [400L, 900L, 1000L] || [150L, 2000L, 899L, 799L]      || [350L, 1400L, 301L, 399L]
    }

    @Unroll
    def "binary search"() {
        when:
        LazyFaith.ClosestPositions positions = LazyFaith.ClosestPositions.fromListAndTarget(list, target)

        then:
        positions.leftClosest == expectedLeft
        positions.rightClosest == expectedRight

        where:
        list                           || target || expectedLeft || expectedRight
        [10L, 20L, 30L, 40L, 50L]      || 51L    || of(50L)      || empty()
        [10L, 20L, 30L, 40L, 50L]      || 50L    || of(50L)      || of(50L)
        [10L, 20L, 30L, 40L, 50L]      || 49L    || of(40L)      || of(50L)
        [10L, 20L, 30L, 40L, 50L]      || 40L    || of(40L)      || of(40L)
        [10L, 20L, 30L, 40L, 50L]      || 31L    || of(30L)      || of(40L)
        [10L, 20L, 30L, 40L, 50L]      || 30L    || of(30L)      || of(30L)
        [10L, 20L, 30L, 40L, 50L]      || 29L    || of(20L)      || of(30L)
        [10L, 20L, 30L, 40L, 50L]      || 25L    || of(20L)      || of(30L)
        [10L, 20L, 30L, 40L, 50L]      || 20L    || of(20L)      || of(20L)
        [10L, 20L, 30L, 40L, 50L]      || 19L    || of(10L)      || of(20L)
        [10L, 20L, 30L, 40L, 50L]      || 11L    || of(10L)      || of(20L)
        [10L, 20L, 30L, 40L, 50L]      || 10L    || of(10L)      || of(10L)
        [10L, 20L, 30L, 40L, 50L]      || 8L     || empty()      || of(10L)
        [10L, 20L, 30L, 40L, 50L]      || 9L     || empty()      || of(10L)
        [10L, 20L, 30L, 40L, 50L, 60L] || 10L    || of(10L)      || of(10L)
        [10L, 20L, 30L, 40L, 50L, 60L] || 19L    || of(10L)      || of(20L)
        [10L, 20L, 30L, 40L, 50L, 60L] || 20L    || of(20L)      || of(20L)
        [10L, 20L, 30L, 40L, 50L, 60L] || 21L    || of(20L)      || of(30L)
        [10L, 20L, 30L, 40L, 50L, 60L] || 30L    || of(30L)      || of(30L)
        [10L, 20L, 30L, 40L, 50L, 60L] || 31L    || of(30L)      || of(40L)
        [10L, 20L, 30L, 40L, 50L, 60L] || 40L    || of(40L)      || of(40L)
        [10L, 20L, 30L, 40L, 50L, 60L] || 50L    || of(50L)      || of(50L)
        [10L, 20L, 30L, 40L, 50L, 60L] || 60L    || of(60L)      || of(60L)
        [10L, 20L, 30L, 40L, 50L, 60L] || 70L    || of(60L)      || empty()
        [10L, 20L, 30L, 40L, 50L, 60L] || 0L     || empty()      || of(10L)

    }
}
