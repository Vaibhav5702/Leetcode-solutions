class Solution {
    class TrieNode{
        TrieNode[] links=new TrieNode[26];
        boolean isFolder=false;
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
        public void setFolder()
        {
            isFolder=true;
        }
        public boolean isFolder()
        {
            return isFolder;
        }
    }
    TrieNode root;
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder,(a,b)->a.length()-b.length());
        root=new TrieNode();
        List<String> ans=new ArrayList();
        for(String s:folder)
        {
            if(insert(s))
                ans.add(s);
        }
        return ans;
    }
    public boolean insert(String word)
    {
        TrieNode node=root;
        for(int i=1;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(ch!='/')
            {
                if(!node.containsKey(ch))
                    node.set(ch);
                node=node.get(ch);
            }
            else if(node.isFolder())
                return false;
        }
        node.setFolder();
        return true;
    }
}