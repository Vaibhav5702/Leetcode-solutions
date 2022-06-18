class WordFilter {

    class TrieNode
    {
        TrieNode[] node=new TrieNode[256];
        int index=-1;
        public boolean containsKey(char ch)
        {
            return node[ch]!=null;
        }
        public void put(char ch)
        {
            node[ch]=new TrieNode();
        }
        public TrieNode get(char ch)
        {
            return node[ch];
        }
    }
    TrieNode root;
    public WordFilter(String[] words) {
        root=new TrieNode();
        for(int i=0;i<words.length;i++)
        {
            for(int j=0;j<words[i].length();j++)
            {
                insert(words[i].substring(j)+"#"+words[i],i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        TrieNode node=root;
        String pre=suffix+"#"+prefix;
        for(char ch:pre.toCharArray())
        {
            if(!node.containsKey(ch))
                return -1;
            node=node.get(ch);
        }
        return node.index;
    }
    public void insert(String word,int index)
    {
        TrieNode node=root;
        for(char ch:word.toCharArray())
        {
            if(!node.containsKey(ch))
                node.put(ch);
            node=node.get(ch);
            node.index=Math.max(node.index,index);
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */