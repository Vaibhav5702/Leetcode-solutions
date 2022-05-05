class Solution {
    int[] parent;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] inDegree=new int[edges.length+1];
        for(int[] edge:edges)
        {
            inDegree[edge[1]]++;
        }
        for(int i=edges.length-1;i>=0;i--)
        {
            int[] edge=edges[i];
            if(inDegree[edge[1]]>1)
            {
                int[] ret=findRedundant(edges,i);
                if(ret==null)
                    return edge;
            }
        }
        return findRedundant(edges,edges.length);
    }
    public int[] findRedundant(int[][] edges,int skip)
    {
        parent=new int[edges.length+1];
        for(int i=0;i<parent.length;i++)
        {
            parent[i]=i;
        }
        for(int i=0;i<edges.length;i++)
        {
            if(i==skip)
                continue;
            int[] edge=edges[i];
            if(findPar(edge[0])==findPar(edge[1]))
                return edge;
            union(edge[0],edge[1]);
        }
        return null;
    }
    public int findPar(int node)
    {
        if(node!=parent[node])
            parent[node]=findPar(parent[node]);
        return parent[node];
    }
    public void union(int u, int v)
    {
        u=findPar(u);
        v=findPar(v);
        parent[v]=u;
    }
}