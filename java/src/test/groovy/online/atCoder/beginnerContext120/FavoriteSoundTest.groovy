package online.atCoder.beginnerContext120

import spock.lang.Specification
import spock.lang.Unroll

class FavoriteSoundTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = FavoriteSound.process(new FavoriteSound.TestCase(A, B, C))

        then:
        result == expected

        where:
        A   || B  || C  || expected
        2   || 11 || 4  || "4"
        3   || 9  || 5  || "3"
        100 || 1  || 10 || "0"
    }

}
