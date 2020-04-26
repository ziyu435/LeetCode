/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null) {
            return new TreeNode(val);
        }

        if(root.right == null && root.left != null) {
            if(val > root.val) {
                root.right = new TreeNode(val);
            } else {
                insertIntoBST(root.left, val);
            }
        } else if(root.left == null && root.right != null) {
            if(val < root.val) {
                root.left = new TreeNode(val);
            } else {
                insertIntoBST(root.right, val);
            }
        } else if(root.right == null && root.left == null) {
            if(val < root.val) {
                root.left = new TreeNode(val);
            } else {
                root.right = new TreeNode(val);
            }
        } else {
            if(val < root.val) {
                insertIntoBST(root.left, val);
            } else {
                insertIntoBST(root.right, val);
            }
        }
        return root;

    }
}


// More succinct way of recursion:

// class Solution {
//     public TreeNode insertIntoBST(TreeNode root, int val) {

//         if(root == null) {
//             return new TreeNode(val);
//         }

//         if(val < root.val) {
//             insertIntoBST(root.left, val);
//         } else {
//             insertIntoBST(root.right, val);
//         }
// }
