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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null)
            return null;
        ListNode start=head,curr=head,prev=head;
        for(int i=1;i<=n;i++)
        {
            start=start.next;
        }
        while(start!=null)
        {
            start=start.next;
            prev=curr;
            curr=curr.next;
        }
        if(curr==head)
            return head.next;
        prev.next=curr.next;
        return head;
    }
}