class Solution {
    class TrieNode{
        TrieNode[] links=new TrieNode[26];
        boolean isEnd=false;
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
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root=new TrieNode();
        for(String product:products)
        {
            insert(product);
        }
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<searchWord.length();i++)
        {
            List<String> list=new ArrayList();
            getSuggestions(i,searchWord,list);
            ans.add(list);
        }
        return ans;
    }
    public void getSuggestions(int index,String word,List<String> list)
    {
        TrieNode node=root;
        for(int i=0;i<=index;i++)
        {
            char ch=word.charAt(i);
            if(!node.containsKey(ch))
                return;
            node=node.get(ch);
        }
        StringBuilder sb=new StringBuilder(word.substring(0,index+1));
        dfs(node,list,sb);
    }
    public void dfs(TrieNode node,List<String> list,StringBuilder sb)
    {
        if(node.isEnd())
        {
            list.add(sb.toString());
        }
        for(char ch='a';ch<='z';ch++)
        {
            if(list.size()==3)
                return;
            if(node.containsKey(ch))
            {
                sb.append(ch);
                dfs(node.get(ch),list,sb);
                sb.setLength(sb.length()-1);
            }
        }
    }
    public void insert(String key) {
        TrieNode node=root;
        for(char ch:key.toCharArray())
        {
            if(!node.containsKey(ch))
                node.set(ch);
            node=node.get(ch);
        }
        node.setEnd();
    }
}