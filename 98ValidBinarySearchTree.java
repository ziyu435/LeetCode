/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        ResultType result = isValidBSTHelper(root);
        return result.isBST;
    }

    public class ResultType {
        public long maxValue;  // max value of the subtree
        public long minValue;  // min value of the subtree
        public boolean isBST;

        public ResultType(long maxValue, long minValue, boolean isBST) {
            this.maxValue = maxValue;
            this.minValue = minValue;
            this.isBST = isBST;
        }
    }


    public ResultType isValidBSTHelper(TreeNode node) {

        // recursion terminal condition
        if (node == null) {
            return new ResultType(Long.MIN_VALUE, Long.MAX_VALUE, true);
        }

        ResultType left = isValidBSTHelper(node.left);
        ResultType right = isValidBSTHelper(node.right);

        // If either the subtree is not BST, then there is no need to compare the values.
        if(!left.isBST || !right.isBST) {
            return new ResultType(-1, -1, false);
        }

        // When both subtrees are BST, then we have to check whether the left subtree < node < right subtree
        boolean isBST = (left.maxValue < node.val) && (node.val < right.minValue);
        return new ResultType(
                Math.max(node.val, Math.max(left.maxValue, right.maxValue)),
                Math.min(node.val, Math.min(left.minValue, right.minValue)),
                isBST
        );
    }
}

// PS:
// The reason why we use Long.MAX_VALUE and Long.MIN_VALUE is due to the corner case:
// the root tree is a single node with the value of Integer.MAX_VALUE and Integer.MIN_VALUE.
// int: 32 bits
// long: 64 bits
// double: 64 bits
// Double.MAX_VALUE > Long.MAX_VALUE > Integer.MAX_VALUE
// So use Double is also ok.


