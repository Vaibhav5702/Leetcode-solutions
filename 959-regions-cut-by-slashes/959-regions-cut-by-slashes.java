class Solution {
    int region;
    int[] parent;
    public int regionsBySlashes(String[] grid) {
        int n=grid.length+1;
        region=1;
        parent=new int[n*n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0||i==n-1||j==0||j==n-1)
                    parent[i*n+j]=0;
                else
                   parent[i*n+j]=i*n+j; 
            }
            
        }
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-1;j++)
            {
                if(grid[i].charAt(j)=='/')
                    union(i*n+j+1,(i+1)*n+j);
                else if(grid[i].charAt(j)=='\\')
                    union(i*n+j,(i+1)*n+j+1);
            }
        }
        return region;
    }
    public void union(int u,int v)
    {
        u=findPar(u);
        v=findPar(v);
        if(u==v)
            region++;
        parent[u]=v;
    }
    public int findPar(int node)
    {
        if(parent[node]!=node)
            parent[node]=findPar(parent[node]);
        return parent[node];
    }
}