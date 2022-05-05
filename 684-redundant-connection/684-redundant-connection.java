class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        parent=new int[edges.length+1];
        rank=new int[edges.length+1];
        for(int i=0;i<parent.length;i++)
        {
            parent[i]=i;
        }
        for(int[] edge:edges)
        {
            if(findPar(edge[0])==findPar(edge[1]))
                return edge;
            union(edge[0],edge[1]);
        }
        return new int[]{};
    }
    public int findPar(int node)
    {
        if(parent[node]==node)
            return node;
        parent[node]=findPar(parent[node]);
        return parent[node];
    }
    public void union(int u, int v)
    {
        u=findPar(u);
        v=findPar(v);
        if(rank[u]==rank[v])
        {
            parent[v]=u;
            rank[u]++;
        }
        else if(rank[u]>rank[v])
        {
            parent[v]=u;
        }
        else
        {
            parent[u]=v;
        }
    }
}