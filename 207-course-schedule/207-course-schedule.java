class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list=new ArrayList();
        for(int i=0;i<numCourses;i++)
        {
            list.add(new ArrayList<Integer>());
        }
        for(int[] pre:prerequisites)
        {
            list.get(pre[0]).add(pre[1]);
        }
        boolean[] vis=new boolean[numCourses];
        boolean[] dfsvis=new boolean[numCourses];
        boolean flag=false;
        for(int i=0;i<numCourses;i++)
        {
            if(!vis[i]&&dfs(i,vis,dfsvis,list))
                return false;      
        }
        return true;
    }
    public boolean dfs(int s,boolean[] vis,
                      boolean[] dfsvis,List<List<Integer>> adj)
    {
        vis[s]=true;
        dfsvis[s]=true;
        for(int node:adj.get(s))
        {
            if(!vis[node])
            {
                if(dfs(node,vis,dfsvis,adj))
                    return true;
            }
            else if(dfsvis[node])
                return true;
        }
        dfsvis[s]=false;
        return false;
    }
}