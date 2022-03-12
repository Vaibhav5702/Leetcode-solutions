/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map=new HashMap();
        Node dup=new Node(0);
        Node start=dup;
        Node temp=head;
        while(temp!=null)
        {
            Node newNode=new Node(temp.val);
            start.next=newNode;
            start=start.next;
            map.put(temp,newNode);
            temp=temp.next;
        }
        start=dup.next;
        temp=head;
        while(temp!=null)
        {
            start.random=map.get(temp.random);
            start=start.next;
            temp=temp.next;
        }
        return dup.next;
    }
}