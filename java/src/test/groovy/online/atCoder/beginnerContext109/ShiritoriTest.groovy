package online.atCoder.beginnerContext109

import spock.lang.Specification
import spock.lang.Unroll

class ShiritoriTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = Shiritori.process(new Shiritori.TestCase(N, W))

        then:
        result == expected

        where:
        N || W                                                                               || expected
        4 || ["hoge", "english", "hoge", "enigma",]                                          || "No"
        9 || ["basic", "c", "cpp", "php", "python", "nadesico", "ocaml", "lua", "assembly",] || "Yes"
        8 || ["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaa", "aaaaaaa",]                || "No"
        3 || ["abc", "arc", "agc",]                                                          || "No"

    }
}
