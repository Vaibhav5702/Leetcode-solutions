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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3=new ListNode((l1.val+l2.val)%10);
        ListNode head=l3;
        int carry=(l1.val+l2.val)/10;
        l1=l1.next;
        l2=l2.next;
        while(l1!=null&&l2!=null)
        {
            l3.next=new ListNode((l1.val+l2.val+carry)%10);
            carry=(l1.val+l2.val+carry)/10;
            l1=l1.next;
            l2=l2.next;
            l3=l3.next;
        }
        
        while(l1!=null)
        {
            l3.next=new ListNode((l1.val+carry)%10);
            carry=(l1.val+carry)/10;
            l1=l1.next;
            l3=l3.next;
        }
        while(l2!=null)
        {
            l3.next=new ListNode((l2.val+carry)%10);
            carry=(l2.val+carry)/10;
            l2=l2.next;
            l3=l3.next;
        }
        if(carry==1)
        {
            l3.next=new ListNode(1);
            l3=l3.next;
        }
        return head;
    }
}