class Solution {
    class TrieNode{
        TrieNode[] links=new TrieNode[26];
        boolean isWord=false;
        
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
            isWord=true;
        }
        public boolean isEnd()
        {
            return isWord;
        }
    }
    TrieNode root;
    public List<String> wordBreak(String s, List<String> wordDict) {
        root=new TrieNode();
        boolean[] np=new boolean[s.length()];
        for(String word:wordDict)
            insert(word);
        List<String> list=new ArrayList();
        dfs(0,s,np,list,new StringBuilder());
        return list;
    }
    public boolean dfs(int index,String s,boolean[] np,List<String> list,StringBuilder sb)
    {
        if(index==s.length())
        {
            list.add(sb.toString().trim());
            return true;
        }
        if(np[index])
            return false;
        TrieNode node=root;
        for(int i=index;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(!node.containsKey(ch))
                return false;
            node=node.get(ch);
            if(node.isEnd())
            {
                StringBuilder temp=new StringBuilder(sb);
                sb.append(s.substring(index,i+1)+' ');
                if(!dfs(i+1,s,np,list,sb))
                    np[i+1]=false;
                sb=temp;
            }
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