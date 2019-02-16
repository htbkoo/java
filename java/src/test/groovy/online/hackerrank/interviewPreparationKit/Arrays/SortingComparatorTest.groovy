package online.hackerrank.interviewPreparationKit.Arrays

import spock.lang.Specification
import spock.lang.Unroll

class SortingComparatorTest extends Specification {
    @Unroll
    def "It should print each sorted element"() {
        when:
        players.sort(new SortingComparator.Checker())

        then:
        players == expected

        where:
        players                                                                                                           ||
                expected
        [player("amy", 100), player("david", 100), player("heraldo", 50), player("aakansha", 75), player("aleksa", 150),] ||
                [player("aleksa", 150), player("amy", 100), player("david", 100), player("aakansha", 75), player("heraldo", 50),]
    }

    private static SortingComparator.Player player(String name, int score) {
        new SortingComparator.Player(name, score)
    }
}
