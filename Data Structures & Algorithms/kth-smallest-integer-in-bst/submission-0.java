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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        dfs(root, pq);
        
        int result = root.val;
        for(int i = 0; i < k; i++) {
            result = pq.poll();
        }

        return result;
    }

    public void dfs(TreeNode root, PriorityQueue<Integer> pq) {
        if(root == null)
            return;

        pq.add(root.val);
        dfs(root.left, pq);
        dfs(root.right, pq);
    }
}
