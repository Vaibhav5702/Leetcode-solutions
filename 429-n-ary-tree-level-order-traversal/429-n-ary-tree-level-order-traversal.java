/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue=new LinkedList();
        queue.offer(root);
        List<List<Integer>> list=new ArrayList();
        if(root==null)
            return list;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            List<Integer> level=new ArrayList();
            for(int i=0;i<size;i++)
            {
                Node temp=queue.poll();
                level.add(temp.val);
                for(Node a:temp.children)
                {
                    queue.offer(a);
                }
            }
            list.add(level);
        }
        return list;
    }
}