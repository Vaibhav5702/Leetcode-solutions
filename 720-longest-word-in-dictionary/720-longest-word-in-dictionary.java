class Solution {
    public class Node{
        Node[] links=new Node[26];
        boolean flag=false;
        public boolean containsKey(char ch)
        {
            return links[ch-'a']!=null;
        }
        public void addKey(char ch)
        {
            links[ch-'a']=new Node();
        }
        public Node getKey(char ch)
        {
            return links[ch-'a'];
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
    String ans="";
    public String longestWord(String[] words) {
        root=new Node();
        for(String word:words)
        {
            insert(word);
        }
        check(root,new StringBuilder());
        return ans;
    }
    public void check(Node root,StringBuilder sb)
    {
        if(root==null)
        {
            return;
        }
        if(root.isEnd()&&sb.length()>ans.length())
            ans=sb.toString();
        for(char i='a';i<='z';i++)
        {
            if(root.containsKey(i))
            {
                if(!root.getKey(i).isEnd())
                    continue;
                sb.append(i);
                check(root.getKey(i),sb);
                sb.setLength(sb.length()-1);
            }
        }
    }
    public void insert(String word) {
        Node node=root;
        for(char ch:word.toCharArray())
        {
            if(!node.containsKey(ch))
                node.addKey(ch);
            node=node.getKey(ch);
        }
        node.setEnd();
    }
}