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
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null||head.next==null)
            return head;
        int count=0;
        ListNode dummy=head;
        ListNode beginK=null,endK=null;
        while(dummy!=null)
        {
            count++;
            if(count==k)
                beginK=dummy;
            dummy=dummy.next;
        }
        endK=head;
        while(count!=k)
        {
            endK=endK.next;
            count--;
        }
        int temp=beginK.val;
        beginK.val=endK.val;
        endK.val=temp;
        return head;
    }
}