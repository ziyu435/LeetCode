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
    public TreeNode searchBST(TreeNode root, int val) {

        // recursion terminal condition
        if(root == null || root.val == val) {
            return root;
        }
        return root.val < val ? searchBST(root.right, val) : searchBST(root.left, val);
    }
}
