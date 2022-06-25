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
        if(head.next==null||head.next.next==null)
            return;
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=fast==null?slow:slow.next;
        Stack<ListNode> stack=new Stack();
        while(temp!=null)
        {
            stack.push(temp);
            temp=temp.next;
        }
        temp=head;
        while(temp!=slow)
        {
            ListNode next=temp.next;
            temp.next=stack.pop();
            temp=temp.next;
            temp.next=next;
            temp=temp.next;
        }
        temp.next=null;
    }
}