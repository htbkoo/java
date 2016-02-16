package online.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Hey on 14/2/16
 */

/*

https://leetcode.com/problems/permutations/

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

Subscribe to see which companies asked this question

*/

public class PermutationsII {
//    21ms
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> prev_set;
        Set<List<Integer>> set = new HashSet<>();

        for (final int num : nums) {
            prev_set = new HashSet<>();
            if (set.isEmpty()){
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(num);
                prev_set.add(tempList);
            }else{
                for (final List<Integer> l:set){
                    for (int i=0;i<l.size();++i){
                        ArrayList<Integer> tempList = new ArrayList<>(l);
                        tempList.add(i,num);
                        prev_set.add(tempList);
                    }
                    ArrayList<Integer> tempList = new ArrayList<>(l);
                    tempList.add(num);
                    prev_set.add(tempList);
                }
            }
            set=prev_set;
        }

        return new ArrayList<>(set);
    }
}
