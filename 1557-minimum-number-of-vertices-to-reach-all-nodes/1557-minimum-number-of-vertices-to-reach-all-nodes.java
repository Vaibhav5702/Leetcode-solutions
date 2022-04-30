class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // boolean[] visited=new boolean[n];
        // List<List<Integer>> adj=new ArrayList();
        // for(int i=0;i<n;i++)
        // {
        //     adj.add(new ArrayList<Integer>());
        // }
        // for(List<Integer> edge:edges)
        // {
        //     adj.get(edge.get(0)).add(edge.get(1));
        // }
        // List<Integer> ans=new ArrayList();
        // for(int i=0;i<n;i++)
        // {
        //     if(!visited[i])
        //     {
        //         ans.add(i);
        //         visited[i]=true;
        //         dfs(i,adj,visited);
        //     }
        // }
        // return ans;
        int indegree[]=new int[n];
        for(List<Integer> edge:edges)
        {
            indegree[edge.get(1)]++;
        }
        List<Integer> list=new ArrayList();
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
                list.add(i);
        }
        return list;
    }
    // public void dfs(int s,List<List<Integer>> adj, boolean[] visited)
    // {
    //     for(int node:adj.get(s))
    //     {
    //         visited[node]=true;
    //         dfs(node,adj,visited);
    //     }
    // }
}