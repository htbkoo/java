package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class EncryptionTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = Encryption.Solution.encryption(s)

        then:
        actual == expected

        where:
        s              || expected
        "haveaniceday" || "hae and via ecy"
        "feedthedog"   || "fto ehg ee dd"
        "chillout"     || "clu hlt io"
    }
}
