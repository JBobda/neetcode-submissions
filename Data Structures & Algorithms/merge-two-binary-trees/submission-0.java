/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2, new TreeNode());
    }

    private TreeNode dfs(TreeNode root1, TreeNode root2, TreeNode newTree) {
        if(root1 == null && root2 == null)
            return null;
        if(root1 == null) {
            newTree = root2;
            return newTree;
        }
        if(root2 == null) {
            newTree = root1;
            return newTree;
        }

        newTree.val = root1.val + root2.val;

        newTree.left = dfs(root1.left, root2.left, new TreeNode());
        newTree.right = dfs(root1.right, root2.right, new TreeNode());

        return newTree;
    }
}