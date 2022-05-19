class Trie {

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
    }
    Node root;
    public Trie() {
        root=new Node();
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
    
    public boolean search(String word) {
        Node node=root;
        for(char ch:word.toCharArray())
        {
            if(!node.containsKey(ch))
                return false;
            node=node.getKey(ch);
        }
        return node.flag;
    }
    
    public boolean startsWith(String prefix) {
        Node node=root;
        for(char ch:prefix.toCharArray())
        {
            if(!node.containsKey(ch))
                return false;
            node=node.getKey(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */