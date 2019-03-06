package interview.cci.ch3StacksAndQueues

import spock.lang.Specification
import spock.lang.Unroll

abstract class StackOfPlates4TestBase extends Specification {
    abstract char[] urlify(char[] chars, int trueLength)
}

class SetOfStacksTest extends Specification {

    @Unroll
    def "should implement SetOfStacks"() {
        when:
        input.each { stacks.push(it) }

        then:
        def actual = (1..expected.size()).collect {
            def item = stacks.peek()
            def numStacks = stacks.numStacks()
            stacks.pop()
            s(item, numStacks)
        }
        actual == expected

        where:
        stacks                                     || input                          || expected
        new StackOfPlates4.SetOfStacks<Integer>(3) || [1, 2, 3, 4, 5, 6, 7, 8, 9, 0] || [s(0, 4), s(9, 3),]
        new StackOfPlates4.SetOfStacks<Integer>(5) || [1, 2, 3, 4, 5, 6, 7, 8, 9, 0] || [s(0, 2), s(9, 2), s(8, 2), s(7, 2), s(6, 2), s(5, 1), s(4, 1), s(3, 1), s(2, 1), s(1, 1),]
    }

    // state to compare
    def s(item, numStacks) {
        return [item, numStacks]
    }
}

class SetOfStacksWithPopAtTest extends Specification {
}
