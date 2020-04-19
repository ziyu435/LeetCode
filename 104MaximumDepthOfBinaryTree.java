public class Solution {
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

// For a tree with n nodes, the maxDepth is called 2n+1 times.
// BTW, a tree with n nodes has n+1 links pointed to null.
