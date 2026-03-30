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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return dfs(root, result);
    }

    public List<Integer> dfs(TreeNode root, List<Integer> list) {
        if(root == null) {
            return list;
        }

        list = dfs(root.left, list);
        list.add(root.val);
        list = dfs(root.right, list);

        return list;
    }
}