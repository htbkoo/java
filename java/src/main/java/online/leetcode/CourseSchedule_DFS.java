package online.leetcode;

/*

https://leetcode.com/problems/course-schedule/

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.

Note:

    The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
    You may assume that there are no duplicate edges in the input prerequisites.

*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule_DFS {
    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Set<Integer>> dependencies = new ArrayList<>();
            for (int i=0;i<numCourses;++i){
                dependencies.add(new HashSet<>());
            }

            for (int[] prerequisite: prerequisites){
                int after = prerequisite[0], before = prerequisite[1];
                dependencies.get(after).add(before);
            }

            for (int i=0;i<numCourses;++i){
                if (hasCycle(dependencies, i, numCourses)){
                    return false;
                }
            }

            return true;
        }

        private boolean hasCycle(List<Set<Integer>> dependencies, int i, int numCourses){
            boolean[] visited = new boolean[numCourses];
            boolean[] visiting = new boolean[numCourses];
            return hasCycle(visited, visiting, dependencies, i);
        }

        private boolean hasCycle(boolean[] visited, boolean[] visiting, List<Set<Integer>> dependencies, int current){
            visiting[current] = true;
            Set<Integer> dependency = dependencies.get(current);
            for (int d: dependency){
                if (!visited[d]){
                    if (visiting[d] || hasCycle(visited, visiting, dependencies, d)){
                        return true;
                    }
                }
            }
            visited[current] = true;
            return false;
        }
    }
}
