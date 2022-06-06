/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummyA=headA,dummyB=headB;
        while(headA!=null&&headB!=null)
        {
            headA=headA.next;
            headB=headB.next;
        }
        while(headA!=null)
        {
            dummyA=dummyA.next;
            headA=headA.next;
        }
        while(headB!=null)
        {
            dummyB=dummyB.next;
            headB=headB.next;
        }
        while(dummyA!=null)
        {
            if(dummyA==dummyB)
                return dummyA;
            dummyA=dummyA.next;
            dummyB=dummyB.next;
        }
        return dummyA;
    }
}