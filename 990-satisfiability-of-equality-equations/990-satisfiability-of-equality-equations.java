class Solution {
    int parent[];
    public boolean equationsPossible(String[] equations) {
        parent=new int[26];
        for(int i=0;i<26;i++)
        {
            parent[i]=i;
        }
        for(String eq:equations)
        {
            int u=eq.charAt(0)-'a';
            int v=eq.charAt(3)-'a';
            if(eq.charAt(1)=='=')
            {
                union(u,v);
            }
        }
        for(String eq:equations)
        {
            if(eq.charAt(1)=='!'&&findPar(eq.charAt(0)-'a')==findPar(eq.charAt(3)-'a'))
            {
                return false;
            }
        }
        return true;
    }
    public void union(int u,int v)
    {
        u=findPar(u);
        v=findPar(v);
        if(u==v)
            return;
        parent[u]=v;
    }
    public int findPar(int node)
    {
        if(parent[node]!=node)
        {
            parent[node]=findPar(parent[node]);
        }
        return parent[node];
    }
}