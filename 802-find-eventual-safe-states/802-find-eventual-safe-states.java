class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] safe=new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(safe[i]==0)
                safe[i]=dfs(i,graph,safe)?1:-1;
            
        }
        List<Integer> list=new ArrayList();
        for(int i=0;i<safe.length;i++)
        {
            if(safe[i]==1)
                list.add(i);
        }
        return list;
    }
    public boolean dfs(int s,int[][] graph,int[] safe)
    {
        if(safe[s]!=0)
            return safe[s]==1;
        safe[s]=-1;
        for(int node:graph[s])
        {
            if(safe[node]==1)
                continue;
            if(safe[node]==-1||!dfs(node,graph,safe))
            {
                return false;
            }
        }
        safe[s]=1;
        return true;
    }
}