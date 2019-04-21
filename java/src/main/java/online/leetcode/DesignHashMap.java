/*

https://leetcode.com/problems/minimum-index-sum-of-two-lists/

Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

    put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
    get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
    remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.


Example:

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);
hashMap.put(2, 2);
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found)


Note:

    All keys and values will be in the range of [0, 1000000].
    The number of operations will be in the range of [1, 10000].
    Please do not use the built-in HashMap library.

*/

package online.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.IntStream.range;

public class DesignHashMap {
    class MyHashMap {
        private class Bucket {
            private static final int NOT_FOUND = -1;

            private class Entry {
                final int key;
                final int value;

                private Entry(int key, int value) {
                    this.key = key;
                    this.value = value;
                }
            }

            final List<Entry> bucket;

            private Bucket() {
                this.bucket = new ArrayList<>();
            }

            public void put(int key, int value) {
                Entry e = new Entry(key, value);
                Optional<Integer> index = findIndex(key);
                if (index.isPresent()) {
                    Integer i = index.get();
                    bucket.remove((int) i);
                    bucket.add(i, e);
                } else {
                    addToBucket(e);
                }
            }

            public int get(int key) {
                Optional<Integer> index = findIndex(key);
                return index.map(bucket::get).map(entry -> entry.value)
                        .orElse(NOT_FOUND);
            }

            public void remove(int key) {
                Optional<Integer> index = findIndex(key);
                index.ifPresent(i -> bucket.remove((int) i));
            }

            private void addToBucket(Entry e) {
                bucket.add(e);
            }

            private Optional<Integer> findIndex(int key) {
                for (int i = 0; i < bucket.size(); ++i) {
                    if (bucket.get(i).key == key) {
                        return Optional.of(i);
                    }
                }
                return Optional.empty();
            }
        }

        private static final int NUM_BUCKETS = 1000;
        private static final int KEY_RANGE = 1000000;
        private final Bucket[] buckets;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            this.buckets = new Bucket[NUM_BUCKETS];
            range(0, NUM_BUCKETS).forEach(i -> this.buckets[i] = new Bucket());
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            this.buckets[getBucketId(key)].put(key, value);
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            return this.buckets[getBucketId(key)].get(key);
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            this.buckets[getBucketId(key)].remove(key);
        }

        private int getBucketId(int key) {
            return key % NUM_BUCKETS;
        }
    }

    /*
      Your MyHashMap object will be instantiated and called as such:
      MyHashMap obj = new MyHashMap();
      obj.put(key,value);
      int param_2 = obj.get(key);
      obj.remove(key);
     */
}
