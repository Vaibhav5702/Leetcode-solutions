class Solution {
    int[] parent;
    public int removeStones(int[][] stones) {
        parent=new int[stones.length];
        for(int i=0;i<stones.length;i++)
        {
            parent[i]=i;
        }
        for(int i=0;i<stones.length;i++)
        {
            for(int j=i+1;j<stones.length;j++)
            {
                if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1])
                {
                    union(i,j);
                }
            }
        }
        int count=0;
        for(int i=0;i<stones.length;i++)
        {
            if(parent[i]!=i)
                count++;
        }
        return count;
    }
    public int findPar(int node)
    {
        if(parent[node]!=node)
        {
            parent[node]=findPar(parent[node]);
        }
        return parent[node];
    }
    public void union(int i, int j)
    {
        i=findPar(i);
        j=findPar(j);
        if(i!=j)
        {
            parent[j]=i;
        }
    }
}