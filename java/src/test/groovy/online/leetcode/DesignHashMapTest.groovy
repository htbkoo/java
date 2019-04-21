package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class DesignHashMapTest extends Specification {
    @Unroll
    def "test"() {
        given:
        def actual = []
        DesignHashMap.MyHashMap hashMap = new DesignHashMap.MyHashMap()

        when:
        hashMap.put(1, 1)
        hashMap.put(2, 2)
        actual.add(hashMap.get(1))            // returns 1
        actual.add(hashMap.get(3))            // returns -1 (not found)
        hashMap.put(2, 1)          // update the existing value
        actual.add(hashMap.get(2))            // returns 1
        hashMap.remove(2)          // remove the mapping for 2
        actual.add(hashMap.get(2))            // returns -1 (not found)

        then:
        actual == [1, -1, 1, -1]

    }
}
