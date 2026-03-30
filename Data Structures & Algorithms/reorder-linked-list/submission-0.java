/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        Stack<ListNode> stack = new Stack<>();
        while(right != null) {
            stack.add(right);
            right = right.next;
        }

        while(left != null) {
            right = stack.pop();
            
            if(left == right || left.next == right) {
                right.next = null;
                break;
            }

            ListNode nextLeft = left.next;

            left.next = right;
            right.next = nextLeft;

            left = nextLeft;
        }


    }
}
