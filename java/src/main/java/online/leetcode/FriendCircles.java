package online.leetcode;

/*

https://leetcode.com/problems/friend-circles/

547. Friend Circles

 There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

Example 1:

Input:
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
The 2nd student himself is in a friend circle. So return 2.

Example 2:

Input:
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.

Note:

    N is in range [1,200].
    M[i][i] = 1 for all students.
    If M[i][j] = 1, then M[j][i] = 1.

*/

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

public class FriendCircles {
    public int findCircleNum(int[][] M) {
        final int N = M.length;

        final DisjointSets disjointSets = DisjointSets.fromMatrix(N, M);

        return disjointSets.getDisjointTrees().size();
    }

    private static class DisjointSets {

        private final List<DisjointSetTree> trees;

        public DisjointSets(List<DisjointSetTree> trees) {
            this.trees = trees;
        }

        static DisjointSets fromMatrix(int N, int[][] M) {
            final List<DisjointSetTree> trees = range(0, N).mapToObj(i -> new DisjointSetTree()).collect(Collectors.toList());

            range(0, N).forEach(i ->
                    range(0, N).filter(j -> i != j && M[i][j] == 1)
                            .forEach(j ->
                                    trees.get(i).union(trees.get(j))
                            )
            );

            return new DisjointSets(trees);
        }

        public Set<DisjointSetTree> getDisjointTrees() {
            return trees.stream().map(DisjointSetTree::find).collect(Collectors.toSet());
        }
    }

    private static class DisjointSetTree {
        DisjointSetTree parent = this;
        int rank = 0;

        public DisjointSetTree find() {
            if (this.parent != this) {
                this.parent = this.parent.find();
            }
            return this.parent;
        }

        public void union(DisjointSetTree other) {
            DisjointSetTree xRoot = find();
            DisjointSetTree yRoot = other.find();
            if (xRoot != yRoot) {
                if (xRoot.rank < yRoot.rank) {
                    DisjointSetTree temp = xRoot;
                    // swapping in Java, sigh
                    //noinspection SuspiciousNameCombination
                    xRoot = yRoot;
                    yRoot = temp;
                }
                yRoot.parent = xRoot;
                if (xRoot.rank == yRoot.rank) {
                    xRoot.rank = xRoot.rank + 1;
                }
            }
        }
    }

}
