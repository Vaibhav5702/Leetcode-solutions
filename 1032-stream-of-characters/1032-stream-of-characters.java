class StreamChecker {

    char[] ch;
    int idx=40000;
    class TrieNode{
        TrieNode[] node=new TrieNode[26];
        boolean end=false;
        public boolean containsKey(char ch)
        {
            return node[ch-'a']!=null;
        }
        public void put(char ch)
        {
            node[ch-'a']=new TrieNode();
        }
        public TrieNode get(char ch)
        {
            return node[ch-'a'];
        }
        public void setEnd()
        {
            end=true;
        }
    }
    TrieNode root;
    public StreamChecker(String[] words) {
        root=new TrieNode();
        ch=new char[40001];
        for(String word:words)
        {
            insertRev(word);
        }
    }
    public void insertRev(String word)
    {
        TrieNode node=root;
        for(int i=word.length()-1;i>=0;i--)
        {
            char k=word.charAt(i);
            if(!node.containsKey(k))
                node.put(k);
            node=node.get(k);
        }
        node.setEnd();
    }
    public boolean query(char letter) {
        ch[idx--]=letter;
        return contains(ch);
    }
    public boolean contains(char[] ch)
    {
        TrieNode node=root;
        for(int i=idx+1;i<=40000;i++)
        {
            if(!node.containsKey(ch[i]))
                return false;
            node=node.get(ch[i]);
            if(node.end)
                return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */