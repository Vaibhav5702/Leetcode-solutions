class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj=new ArrayList();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] dislike:dislikes)
        {
            adj.get(dislike[0]).add(dislike[1]);
            adj.get(dislike[1]).add(dislike[0]);
        }
        int[] colour=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            if(colour[i]==0)
            {
                colour[i]=1;
                if(!dfs(i,adj,colour))
                    return false;
            }
        }
        return true;
    }
    public boolean dfs(int s,List<List<Integer>> adj,int[] colour)
    {
        for(int node:adj.get(s))
        {
            if(colour[node]==0)
            {
                colour[node]=3-colour[s];
                if(!dfs(node,adj,colour))
                    return false;
            }
            else if(colour[node]==colour[s])
                return false;
        }
        return true;
    }
}