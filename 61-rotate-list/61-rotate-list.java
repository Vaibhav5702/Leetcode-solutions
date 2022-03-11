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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)
            return head;
        ListNode temp=head;
        int len=0;
        while(temp!=null)
        {
            len++;
            temp=temp.next;
        }
        k=k%len;
        if(k==0)
            return head;
        ListNode prev=head,klast=head,prevTemp=head;
        temp=head;
        while(k!=0)
        {
            k--;
            temp=temp.next;
        }
        while(temp!=null)
        {
            prev=klast;
            klast=klast.next;
            prevTemp=temp;
            temp=temp.next;
        }
        prev.next=null;
        prevTemp.next=head;
        return klast;
    }
}