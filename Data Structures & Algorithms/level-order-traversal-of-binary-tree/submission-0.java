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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> nums = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                if(nodes.peek() == null){
                    nodes.poll();
                    continue;
                }
                nodes.add(nodes.peek().left);
                nodes.add(nodes.peek().right);
                nums.add(nodes.poll().val);
            }
            
            if(nodes.size() > 0)
                list.add(nums);
        }

        return list;
    }
}
