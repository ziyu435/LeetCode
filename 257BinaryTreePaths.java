/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        constructPath(root, "", paths);
        return paths;
    }

    /**
     * This method is used to extend the path to the current node and update the linked list.
     * @param path This is a string ended with '->' that represents the path
     *             from the original root node to the current root node
     * @param paths This is a linked list that contains all the completed paths
     *              from the original root node to the leaf nodes.
     * */
    public void constructPath(TreeNode root, String path, LinkedList<String> paths) {
        if(root != null) {
            path += Integer.toString(root.val);
            if(root.left == null && root.right == null) {
                paths.add(path);   // if the node is leaf node, then the path is completed
                                   // and should be added to the linked list.
            } else {
                path += "->";      // extend the path
                constructPath(root.left, path, paths);
                constructPath(root.right, path, paths);
            }
        }
    }
}
