package online.leetcode

import online.leetcode.util.Employee
import spock.lang.Specification
import spock.lang.Unroll

class EmployeeImportanceTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new EmployeeImportance.Solution().getImportance(employees, id)

        then:
        actual == expected

        where:
        employees                                                 | id || expected
        [e(1, 5, [2, 3]), e(2, 3, []), e(3, 3, []),]              | 1  || 11
        [e(1, 5, [2, 3]), e(2, 3, [4]), e(3, 4, []), e(4, 1, [])] | 1  || 13
    }

    def e(int id, int importance, List<Integer> subordinates) {
        new Employee(id, importance, subordinates)
    }
}
