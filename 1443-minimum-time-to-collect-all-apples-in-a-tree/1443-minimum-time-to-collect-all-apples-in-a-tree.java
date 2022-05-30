class Solution {
    int count;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj=new ArrayList();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] vis=new boolean[n];
        dfs(0,adj,hasApple,vis);
        return count;
    }
    public boolean dfs(int src,List<List<Integer>> adj,List<Boolean> hasApple,boolean[] vis)
    {
        if(vis[src])
            return false;
        vis[src]=true;
        boolean travel=hasApple.get(src);
        for(int x:adj.get(src))
        {
            travel|=dfs(x,adj,hasApple,vis);
        }
        if(travel&&src!=0)
            count+=2;
        return travel;
    }
}