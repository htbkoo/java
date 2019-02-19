package online.atCoder.practice

import spock.lang.Specification
import spock.lang.Unroll

class PermutationTest extends Specification {
    @Unroll
    def "should generate Permutation"() {
        when:
        List<String> permutation = Permutation.generatePermutation(n)

        then:
        permutation.size() == expected.size()
        new HashSet(permutation) == new HashSet(expected)

        where:
        n || expected
        2 || ["AB", "BA"]
        3 || ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA",]
        4 || ["ABCD", "ABDC", "ACBD", "ACDB", "ADBC", "ADCB", "BACD", "BADC", "BCAD", "BCDA", "BDAC", "BDCA", "CABD", "CADB", "CBAD", "CBDA", "CDAB", "CDBA", "DABC", "DACB", "DBAC", "DBCA", "DCAB", "DCBA",]
        5 || ["ABCDE", "ABCED", "ABDCE", "ABDEC", "ABECD", "ABEDC", "ACBDE", "ACBED", "ACDBE", "ACDEB", "ACEBD", "ACEDB", "ADBCE", "ADBEC", "ADCBE", "ADCEB", "ADEBC", "ADECB", "AEBCD", "AEBDC", "AECBD", "AECDB", "AEDBC", "AEDCB", "BACDE", "BACED", "BADCE", "BADEC", "BAECD", "BAEDC", "BCADE", "BCAED", "BCDAE", "BCDEA", "BCEAD", "BCEDA", "BDACE", "BDAEC", "BDCAE", "BDCEA", "BDEAC", "BDECA", "BEACD", "BEADC", "BECAD", "BECDA", "BEDAC", "BEDCA", "CABDE", "CABED", "CADBE", "CADEB", "CAEBD", "CAEDB", "CBADE", "CBAED", "CBDAE", "CBDEA", "CBEAD", "CBEDA", "CDABE", "CDAEB", "CDBAE", "CDBEA", "CDEAB", "CDEBA", "CEABD", "CEADB", "CEBAD", "CEBDA", "CEDAB", "CEDBA", "DABCE", "DABEC", "DACBE", "DACEB", "DAEBC", "DAECB", "DBACE", "DBAEC", "DBCAE", "DBCEA", "DBEAC", "DBECA", "DCABE", "DCAEB", "DCBAE", "DCBEA", "DCEAB", "DCEBA", "DEABC", "DEACB", "DEBAC", "DEBCA", "DECAB", "DECBA", "EABCD", "EABDC", "EACBD", "EACDB", "EADBC", "EADCB", "EBACD", "EBADC", "EBCAD", "EBCDA", "EBDAC", "EBDCA", "ECABD", "ECADB", "ECBAD", "ECBDA", "ECDAB", "ECDBA", "EDABC", "EDACB", "EDBAC", "EDBCA", "EDCAB", "EDCBA"]
        1 || ["A"]
    }
}
