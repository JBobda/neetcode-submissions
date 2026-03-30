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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(Math.abs(left - right) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }

    }

    public int dfs(TreeNode root) {
        if(root == null)
            return 0;

        int leftHeight = dfs(root.left);

        int rightHeight = dfs(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
