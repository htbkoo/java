package online.leetcode;

/*

https://leetcode.com/problems/course-schedule-ii/

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
             course 0. So the correct course order is [0,1] .

Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .

Note:

    The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
    You may assume that there are no duplicate edges in the input prerequisites.

*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CourseScheduleII {
    static class Solution {
        private static final int[] NO_SOLUTION = new int[0];

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[][] adjMatrix = toAdjacencyMatrix(numCourses, prerequisites);
            int[] inDegrees = countInDegrees(numCourses, prerequisites);

            Deque<Integer> queue = getAllWithZeroInDegrees(numCourses, inDegrees);

            List<Integer> possibleSolution = populateSolution(queue, numCourses, adjMatrix, inDegrees);

            return solutionOrElseEmpty(numCourses, possibleSolution);
        }

        private int[][] toAdjacencyMatrix(int numCourses, int[][] prerequisites){
            int[][] matrix = new int[numCourses][numCourses];
            for (int[] prerequisite: prerequisites){
                int from = prerequisite[1], to = prerequisite[0];
                matrix[from][to]++;
            }
            return matrix;
        }

        private int[] countInDegrees(int numCourses, int[][] prerequisites){
            int[] inDegrees = new int[numCourses];
            for (int[] prerequisite: prerequisites){
                int to = prerequisite[0];
                inDegrees[to]++;
            }
            return inDegrees;
        }

        private Deque<Integer> getAllWithZeroInDegrees(int numCourses, int[] inDegrees){
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i=0;i<numCourses;++i){
                if (inDegrees[i]==0){
                    queue.add(i);
                }
            }
            return queue;
        }

        private List<Integer> populateSolution(Deque<Integer> queue, int numCourses, int[][] adjMatrix, int[] inDegrees){
            List<Integer> solution = new ArrayList<>();
            while (!queue.isEmpty()){
                int current = queue.poll();
                solution.add(current);
                for (int i=0;i<numCourses;++i){
                    if (adjMatrix[current][i]!=0){
                        inDegrees[i]-=adjMatrix[current][i];
                        if (inDegrees[i]==0){
                            queue.add(i);
                        }
                    }
                }
            }
            return solution;
        }

        private int[] solutionOrElseEmpty(int numCourses, List<Integer> sln){
            if (sln.size()==numCourses){
                return sln.stream().mapToInt(i->i).toArray();
            }else{
                return NO_SOLUTION;
            }
        }
    }
}
