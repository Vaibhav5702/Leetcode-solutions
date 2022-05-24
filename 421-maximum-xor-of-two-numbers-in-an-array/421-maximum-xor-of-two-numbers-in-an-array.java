class Solution {
    class TrieNode
    {
        TrieNode links[]=new TrieNode[2];
        
        public boolean containsKey(int bit)
        {
            return links[bit]!=null;
        }
        public void put(int bit)
        {
            links[bit]=new TrieNode();
        }
        public TrieNode get(int bit)
        {
            return links[bit];
        }
    }
    TrieNode root;
    public int findMaximumXOR(int[] nums) {
        root=new TrieNode();
        for(int num:nums)
        {
            insert(num);
        }
        int max=0;
        for(int num:nums)
        {
            max=Math.max(max,getMax(num));
        }
        return max;
    }
    public void insert(int num)
    {
        TrieNode node=root;
        for(int i=31;i>=0;i--)
        {
            int bit=(num>>i)&1;
            if(!node.containsKey(bit))
                node.put(bit);
            node=node.get(bit);
        }
    }
    public int getMax(int num)
    {
        TrieNode node=root;
        int max=0;
        for(int i=31;i>=0;i--)
        {
            int bit=(num>>i)&1;
            if(node.containsKey(1-bit))
            {
                max=max|(1<<i);
                node=node.get(1-bit);
            }
            else
                node=node.get(bit);
        }
        return max;
    }
}