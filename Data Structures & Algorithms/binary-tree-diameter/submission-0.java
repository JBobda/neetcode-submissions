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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode root, int[] res) {
        if(root == null) {
            return 0;
        }

        // Caluculate the height of the left and right subtrees
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);

        // Set the current result to be the max of the current or the current diameter (left height + right height)
        res[0] = Math.max(res[0], left + right);

        // For the node, return its height which is the max height of left or right + one
        return 1 + Math.max(left, right);
    }
}
