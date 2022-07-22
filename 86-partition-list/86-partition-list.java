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
    public ListNode partition(ListNode head, int x) {
        if(head==null)
            return head;
        ListNode last=head,prev=null,curr=head;
        int length=0;
        while(last.next!=null)
        {
            last=last.next;
            length++;
        }
        int i=1;
        while(i<=length+1)
        {
            i++;
            if(curr.val>=x)
            {
                if(curr==head)
                {
                    last.next=head;
                    last=last.next;
                    head=head.next;
                    curr=curr.next;
                }
                else
                {
                    last.next=curr;
                    last=last.next;
                    prev.next=curr.next;
                    curr=curr.next;
                }
            }
            else
            {
                prev=curr;
                curr=curr.next;
            }
        }
        last.next=null;
        return head;
    }
}