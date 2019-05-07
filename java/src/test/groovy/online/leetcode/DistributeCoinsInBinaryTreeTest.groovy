package online.leetcode

import online.leetcode.util.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

class DistributeCoinsInBinaryTreeTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new DistributeCoinsInBinaryTree.Solution().distributeCoins(root)

        then:
        actual == expected

        where:
        root        || expected
        testCase4() || 6
        testCase3() || 5
        testCase1() || 3
        testCase2() || 2
    }

    def testCase1() {
        def root = new TreeNode(0)
        root.left = new TreeNode(3)
        root.right = new TreeNode(0)
        root
    }

    def testCase2() {
        def root = new TreeNode(3)
        root.left = new TreeNode(0)
        root.right = new TreeNode(0)
        root
    }

    def testCase3() {
        def root = new TreeNode(0)
        root.left = new TreeNode(2)
        root.left.left = new TreeNode(0)
        root.left.right = new TreeNode(0)
        root.left.left.left = new TreeNode(1)

        root.right = new TreeNode(3)
        root
    }

    def testCase4() {
        def root = new TreeNode(4)
        root.left = new TreeNode(0)
        root.left.right = new TreeNode(0)
        root.left.right.right = new TreeNode(0)
        root
    }
}
