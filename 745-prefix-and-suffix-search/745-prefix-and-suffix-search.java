class WordFilter {

    class TrieNode
    {
        TrieNode[] node=new TrieNode[26];
        int index=-1;
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
        public void setEnd(int idx)
        {
            index=idx;
        }
    }
    TrieNode root;
    public WordFilter(String[] words) {
        root=new TrieNode();
        for(int i=0;i<words.length;i++)
        {
            insert(words[i],i);
        }
    }
    
    public int f(String prefix, String suffix) {
        TrieNode node=root;
        for(char ch:prefix.toCharArray())
        {
            if(!node.containsKey(ch))
                return -1;
            node=node.get(ch);
        }
        StringBuilder sb=new StringBuilder();
        sb.append(prefix);
        return dfs(node,sb,suffix);
    }
    public int dfs(TrieNode node,StringBuilder sb,String suffix)
    {
        if(node.index!=-1)
        {
            if(sb.toString().endsWith(suffix))
                return node.index;
            else
                return -1;
        }
            
        int index=-1;
        for(char ch='a';ch<='z';ch++)
        {
            if(node.containsKey(ch))
            {
                sb.append(ch);
                index=Math.max(index,dfs(node.get(ch),sb,suffix));
                sb.setLength(sb.length()-1);
            }
        }
        return index;
    }
    public void insert(String word,int index)
    {
        TrieNode node=root;
        for(char ch:word.toCharArray())
        {
            if(!node.containsKey(ch))
                node.put(ch);
            node=node.get(ch);
        }
        node.setEnd(index);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */