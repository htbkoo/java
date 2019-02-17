package online.hackerrank.interviewPreparationKit.Arrays

import spock.lang.Specification
import spock.lang.Unroll

class HashTablesIceCreamParlorTest extends Specification {
    @Unroll
    def "Print two space-separated integers denoting the respective indices for the two distinct flavors they choose to purchase in ascending order"() {
        given:
        ByteArrayOutputStream bo = new ByteArrayOutputStream()
        System.setOut(new PrintStream(bo))

        when:
        HashTablesIceCreamParlor.Solution.whatFlavors(cost as int[], money)

        then:
        bo.flush()
        String allWrittenLines = new String(bo.toByteArray())
        allWrittenLines.contains(expected)

        where:
        cost            || money || expected
        [1, 4, 5, 3, 2] || 4     || "1 4"
        [2, 2, 4, 3]    || 4     || "1 2"
        [2, 1, 3, 5, 6] || 5     || "1 3"
    }
}
