package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class DesignerPDFViewerTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = DesignerPDFViewer.Solution.designerPdfViewer(h as int[], word)

        then:
        actual == expected

        where:
        h                                                                              | word   || expected
        [1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5] | "abc"  || 9
        [1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7] | "zaba" || 28
    }
}
