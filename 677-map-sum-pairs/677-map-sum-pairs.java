class MapSum {

    class TrieNode{
        TrieNode[] links=new TrieNode[26];
        int val=0;
        public boolean containsKey(char ch)
        {
            return links[ch-'a']!=null;
        }
        public void set(char ch)
        {
            links[ch-'a']=new TrieNode();
        }
        public TrieNode get(char ch)
        {
            return links[ch-'a'];
        }
        public void setEnd(int val)
        {
            this.val=val;
        }
    }
    TrieNode root;
    public MapSum() {
        root=new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode node=root;
        for(char ch:key.toCharArray())
        {
            if(!node.containsKey(ch))
                node.set(ch);
            node=node.get(ch);
        }
        node.setEnd(val);
    }
    
    public int sum(String prefix) {
        TrieNode node=root;
        for(char ch:prefix.toCharArray())
        {
            if(!node.containsKey(ch))
                return 0;
            node=node.get(ch);
        }
        return dfs(node);
    }
    public int dfs(TrieNode node)
    {
        if(node==null)
            return 0;
        int sum=node.val;
        for(TrieNode t:node.links)
        {
            sum+=dfs(t);
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */