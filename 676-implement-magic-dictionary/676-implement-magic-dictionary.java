class MagicDictionary {

    class TrieNode{
        TrieNode[] links=new TrieNode[26];
        boolean isEnd=false;
        public boolean containsKey(char ch)
        {
            return links[ch-'a']!=null;
        }
        public void put(char ch)
        {
            links[ch-'a']=new TrieNode();
        }
        public TrieNode get(char ch)
        {
            return links[ch-'a'];
        }
        public void setEnd()
        {
            isEnd=true;
        }
        public boolean isEnd()
        {
            return isEnd;
        }
    }
    TrieNode root;
    public MagicDictionary() {
        root=new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        for(String word:dictionary)
        {
            insert(word);
        }
    }
    
    public boolean search(String searchWord) {
        return getResult(searchWord,root);
        
    }
    public boolean getResult(String word, TrieNode temp)
    {
        TrieNode node=temp;
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            boolean ans=false;
            for(char j='a';j<='z';j++)
            {
                if(ch==j)
                {
                    continue;
                }
                if(node.containsKey(j))
                    ans=ans||check(word,i+1,node.get(j));
            }
            if(ans)
                return true;
            node=node.get(ch);
            if(node==null)
                return false;
        }
        return false;
    }
    public boolean check(String word,int index,TrieNode node)
    {
        for(int i=index;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(!node.containsKey(ch))
                return false;
            node=node.get(ch);
        }
        return node.isEnd();
    }
    public void insert(String word)
    {
        TrieNode node=root;
        for(char ch:word.toCharArray())
        {
            if(!node.containsKey(ch))
                node.put(ch);
            node=node.get(ch);
        }
        node.setEnd();
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */