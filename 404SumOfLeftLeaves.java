/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return processSubtree(root, false);
    }

    private int processSubtree(TreeNode subtree, boolean isLeft) {

        // Base case: this is an empty subtree.
        if(subtree == null) {
            return 0;
        }

        // Base case: this is a leaf node.
        if (subtree.left == null && subtree.right == null) {
            return isLeft ? subtree.val : 0;
        }

        // Recursive case: add and return the results of left and right subtrees.
        return processSubtree(subtree.left, true) + processSubtree(subtree.right, false);
    }
}
