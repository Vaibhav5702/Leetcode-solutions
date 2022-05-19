class WordDictionary {

    public class TrieNode{
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
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node=root;
        for(char ch:word.toCharArray())
        {
            if(!node.containsKey(ch))
                node.put(ch);
            node=node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        return getResult(word,root);
    }
    public boolean getResult(String word,TrieNode temp)
    {
        TrieNode node=temp;
        for(int j=0;j<word.length();j++)
        {
            char ch=word.charAt(j);
            if(ch!='.'&&!node.containsKey(ch))
                return false;
            if(ch=='.')
            {
                boolean ans=false;
                for(char i='a';i<='z';i++)
                {
                    if(node.containsKey(i))
                        ans=ans||getResult(word.substring(j+1),node.get(i));
                }
                return ans;
            }
            else
            {
                node=node.get(ch);
            }
        }
        return node.isEnd();
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */