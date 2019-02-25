package online.atCoder.beginnerContext115

import spock.lang.Specification
import spock.lang.Unroll

import java.util.stream.Collectors
import java.util.stream.IntStream

class ChristmasTest extends Specification {

    @Unroll
    def "should find"() {
        when:
        def result = Christmas.process(new Christmas.TestCase(N, X))

        then:
        result == expected

        where:
        N  || X                || expected
        2  || 7                || 4L
        1  || 1                || 0L
        50 || 4321098765432109 || 2160549382716056L
        50 || 2147483647       || 1073741823L
        50 || 4503599627370493 || 2251799813685247L
        50 || 4503599627370492 || 2251799813685247L
        50 || 4503599627370491 || 2251799813685247L
        50 || 4503599627370490 || 2251799813685247L
    }

    @Unroll
    def "should check boundary"() {
        when:
        def result = Christmas.process(new Christmas.TestCase(N, X))

        then:
        println "N:${N} X:${X} result:${result}"

        where:
        N << IntStream.range(1, 51).boxed().collect(Collectors.toList())
        X << IntStream.range(1, 51).map({ it + 2 }).boxed().collect(Collectors.toList())
    }

    @Unroll
    def "should cartesian product"() {
        when:
        def result = Christmas.process(new Christmas.TestCase(N, X))

        then:
//        result == expected
        println "N:${N} X:${X} result:${result}"

        where:
        N << nRange().boxed().collect(Collectors.toList()).collectMany { i -> xRange().collect { i } }
        X << nRange().boxed().collect(Collectors.toList()).collectMany { xRange().collect { it } }
    }

    def nRange() {
        IntStream.range(40, 51)
    }

    def xRange() {
        IntStream.range(2000950, 2001001)
    }

}
