package interview.cci.ch1ArraysAndStrings

import spock.lang.Specification
import spock.lang.Unroll

abstract class URLify3TestBase extends Specification {
    abstract char[] urlify(char[] chars, int trueLength)

    @Unroll
    def "should test if given string has all unique characters"() {
        when:
        def actual = urlify(s.toCharArray(), trueLength)

        then:
        new String(actual) == expected

        where:
        s                         || trueLength || expected
        "Mr John Smith    "       || 13         || "Mr%20John%20Smith"
        "Mr John  Smith      "    || 14         || "Mr%20John%20%20Smith"
        "Mr John  Smith         "  || 15         || "Mr%20John%20%20Smith%20"
        " Mr John  Smith        " || 15         || "%20Mr%20John%20%20Smith"
    }
}

class UrlifyTest extends URLify3TestBase {

    @Override
    char[] urlify(char[] chars, int trueLength) {
        URLify3.urlifyInPlace(chars, trueLength)
        chars
    }
}
