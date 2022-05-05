class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] vis=new boolean[graph.length];
        int[] safe=new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(safe[i]==0)
                safe[i]=dfs(i,graph,vis,safe)?1:-1;
            
        }
        List<Integer> list=new ArrayList();
        for(int i=0;i<safe.length;i++)
        {
            if(safe[i]==1)
                list.add(i);
        }
        return list;
    }
    public boolean dfs(int s,int[][] graph,boolean[] vis,int[] safe)
    {
        if(vis[s])
            return false;
        vis[s]=true;
        for(int node:graph[s])
        {
            if(safe[node]==1)
                continue;
            if(safe[node]==-1||!dfs(node,graph,vis,safe))
            {
                safe[node]=-1;
                return false;
            }
        }
        safe[s]=1;
        vis[s]=false;
        return true;
    }
}