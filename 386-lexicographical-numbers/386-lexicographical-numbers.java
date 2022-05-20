class Solution {
    public class Node{
        Node[] links=new Node[10];
        boolean flag=false;
        public boolean containsKey(int ch)
        {
            return links[ch]!=null;
        }
        public void addKey(int ch)
        {
            links[ch]=new Node();
        }
        public Node getKey(int ch)
        {
            return links[ch];
        }
        public void setEnd()
        {
            flag=true;
        }
        public boolean isEnd()
        {
            return flag;
        }
    }
    Node root;
    public List<Integer> lexicalOrder(int n) {
        root=new Node();
        for(int i=1;i<=n;i++)
        {
            insert(String.valueOf(i));
        }
        List<Integer> list=new ArrayList();
        addNum(root,new StringBuilder(),list);
        return list;
    }
    public void insert(String word) {
        Node node=root;
        for(char ch:word.toCharArray())
        {
            if(!node.containsKey(ch-'0'))
                node.addKey(ch-'0');
            node=node.getKey(ch-'0');
        }
        node.setEnd();
    }
    public void addNum(Node node,StringBuilder sb,List<Integer> list)
    {
        if(node==null)
            return;
        if(node.isEnd())
        {
            list.add(Integer.parseInt(sb.toString()));
        }
        for(int i=0;i<10;i++)
        {
            if(node.containsKey(i))
            {
                sb.append(i);
                addNum(node.getKey(i),sb,list);
                sb.setLength(sb.length()-1);
            }
        }
    }
}