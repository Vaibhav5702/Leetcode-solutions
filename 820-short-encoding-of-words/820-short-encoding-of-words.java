class Solution {
    int count=0;
    class TrieNode
    {
        TrieNode[] links=new TrieNode[26];
        boolean end=false;
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
            end=true;
        }
    }
    TrieNode root;
    public int minimumLengthEncoding(String[] words) {
        root=new TrieNode();
        for(String word:words)
        {
            insert(word);
        }
        return count;
    }
    public void insert(String word)
    {
        TrieNode node=root;
        boolean flag=false;
        int temp=0;
        for(int i=word.length()-1;i>=0;i--)
        {
            char ch=word.charAt(i);
            temp++;
            if(!node.containsKey(ch))
            {
                node.put(ch);
                flag=true;
            }
            node=node.get(ch);
            if(node.end&&i!=0){
                count-=temp+1;
                node.end=false;
            }
        }
        if(flag){
            count+=word.length()+1;
            node.setEnd();
        }
    }
}