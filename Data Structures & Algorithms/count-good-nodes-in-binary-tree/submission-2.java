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
    public int goodNodes(TreeNode root) {
        return dfs(root, new ArrayList<Integer>());
    }

    public int dfs(TreeNode root, List<Integer> previousNodes) {
        if(root == null)
            return 0;
        
        int count = 0;
        int max = root.val;
        for(Integer node : previousNodes) {
            max = Math.max(node, max);
        }

        if(max == root.val){
            System.out.println(max);
            count = 1;
        }

        previousNodes.add(root.val);

        return count + dfs(root.left, new ArrayList<>(previousNodes)) + dfs(root.right, new ArrayList<>(previousNodes));

    }
}
