/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        Map<Node,Node> map=new HashMap();
        Node newNode=new Node(node.val);
        map.put(node,newNode);
        dfs(node,newNode,map);
        return newNode;
    }
    public void dfs(Node node,Node newNode,Map<Node,Node> map)
    {
        for(Node temp:node.neighbors)
        {
            Node newTemp;
            if(!map.containsKey(temp))
            {
                newTemp=new Node(temp.val);
                map.put(temp,newTemp);
                dfs(temp,newTemp,map);
            }
            else
            {
                newTemp=map.get(temp);
            }
            newNode.neighbors.add(newTemp);
        }
    }
}