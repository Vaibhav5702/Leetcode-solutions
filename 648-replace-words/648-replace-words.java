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
    public String replaceWords(List<String> dictionary, String sentence) {
        root=new Node();
        for(String word:dictionary)
            insert(word);
        String[] words=sentence.split(" ");
        StringBuilder sb=new StringBuilder();
        for(String word:words)
        {
            Node node=root;
            for(int i=0;i<word.length();i++)
            {
                char ch=word.charAt(i);
                sb.append(ch);
                if(!node.containsKey(ch))
                {
                    sb.append(word.substring(i+1));
                    break;
                }
                node=node.getKey(ch);
                if(node.flag==true)
                    break;
            }
            sb.append(" ");
        }
        return sb.toString().trim();
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