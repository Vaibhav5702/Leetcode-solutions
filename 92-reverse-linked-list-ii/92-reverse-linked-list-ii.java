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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp=head,prev=null;
        for(int i=1;i<left;i++)
        {
            prev=temp;
            temp=temp.next;
        }
        ListNode rem=head;
        for(int i=1;i<=right;i++)
        {
            rem=rem.next;
        }
        ListNode revStart=reverse(temp,right-left+1,rem);
        if(prev==null)
            return revStart;
        else
        {
            prev.next=revStart;
            return head;
        }
        
    }
    public ListNode reverse(ListNode head,int length,ListNode prev)
    {
        ListNode next=null,curr=head;
        for(int i=1;i<=length;i++)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            
        }
        return prev;
    }
}