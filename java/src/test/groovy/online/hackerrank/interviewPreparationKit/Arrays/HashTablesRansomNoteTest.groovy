package online.hackerrank.interviewPreparationKit.Arrays

import spock.lang.Specification
import spock.lang.Unroll

class HashTablesRansomNoteTest extends Specification {
    @Unroll
    def "Print Yes if he can use the magazine to create an untraceable replica of his ransom note. Otherwise, print No."() {
        given:
        ByteArrayOutputStream bo = new ByteArrayOutputStream()
        System.setOut(new PrintStream(bo))

        when:
        HashTablesRansomNote.Solution.checkMagazine(magazine.split(" "), note.split(" "))

        then:
        bo.flush()
        String allWrittenLines = new String(bo.toByteArray())
        allWrittenLines.contains(expected)

        where:
        magazine                             || note                    || expected
        "give me one grand today night"      || "give one grand today"  || "Yes"
        "two times three is not four"        || "two times two is four" || "No"
        "ive got a lovely bunch of coconuts" || "ive got some coconuts" || "No"
    }
}
