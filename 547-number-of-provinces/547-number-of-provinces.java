class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        boolean[] vis=new boolean[isConnected.length];
        for(int i=0;i<vis.length;i++)
        {
            if(!vis[i])
            {
                count++;
                dfs(i,isConnected,vis);
            }
        }
        return count;
    }
    public void dfs(int s,int[][] edges,boolean[] vis)
    {
        for(int i=0;i<edges.length;i++)
        {
            if(!vis[i]&&edges[s][i]==1)
            {
                vis[i]=true;
                dfs(i,edges,vis);
            }
        }
    }
}