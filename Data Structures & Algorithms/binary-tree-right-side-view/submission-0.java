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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<Integer> visible = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int n = queue.size();

            TreeNode rightSide = null;
            for(int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if(node != null) {
                    rightSide = node;
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            if(rightSide != null) {
                visible.add(rightSide.val);
            }
        }

        return visible;
    }
}
