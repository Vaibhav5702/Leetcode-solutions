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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
        ListNode res_head=new ListNode(0);
        ListNode res=res_head;
        int count=0;
        while(head!=null&&head.next!=null)
        {
            if(head.val==head.next.val)
                count++;
            else
            {
                if(count==0)
                {
                    res.next=head;
                    res=res.next;
                }
                count=0;
            }
            head=head.next;
        }
        if(count==0)
        {
            res.next=head;
            res=res.next;
        }
        res.next=null;
        return res_head.next;
    }
}