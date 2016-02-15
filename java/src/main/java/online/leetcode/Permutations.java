package online.leetcode;

import java.util.ArrayList;
import java.util.List;

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

public class Permutations {
//    3ms
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> prev_list;
        List<List<Integer>> list = new ArrayList<>();

        for (final int num : nums) {
            prev_list = new ArrayList<>();
            if (list.isEmpty()){
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(num);
                prev_list.add(tempList);
            }else{
                for (final List<Integer> l:list){
                    for (int i=0;i<l.size();++i){
                        ArrayList<Integer> tempList = new ArrayList<>(l);
                        tempList.add(i,num);
                        prev_list.add(tempList);
                    }
                    ArrayList<Integer> tempList = new ArrayList<>(l);
                    tempList.add(num);
                    prev_list.add(tempList);
                }
            }
            list=prev_list;
        }

        return list;
    }
}
