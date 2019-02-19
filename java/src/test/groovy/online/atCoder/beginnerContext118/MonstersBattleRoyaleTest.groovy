package online.atCoder.beginnerContext118

import spock.lang.Specification
import spock.lang.Unroll

class MonstersBattleRoyaleTest extends Specification {
    @Unroll
    def "should find minimum"() {
        when:
        def minHealth = MonstersBattleRoyale.findNumber(new MonstersBattleRoyale.TestCase(N, A))

        then:
        minHealth == expected

        where:
        N || A                                    || expected
        4 || [2, 10, 8, 40]                       || 2
        4 || [5, 13]                              || 1
        4 || [5, 13, 8, 1000000000]               || 1
        3 || [1000000000, 1000000000, 1000000000] || 1000000000
    }
}
