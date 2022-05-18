class Solution {
    class Pair{
        int node;
        int dir;
        Pair(int node, int dir)
        {
            this.node=node;
            this.dir=dir;
        }
    }
    int count;
    public int minReorder(int n, int[][] connections) {
        //Arrays.sort(connections,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        List<List<Pair>> adj=new ArrayList();
        count=0;
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] con:connections)
        {
            adj.get(con[0]).add(new Pair(con[1],-1));
            adj.get(con[1]).add(new Pair(con[0],1));
        }
        boolean[] vis=new boolean[n];
        dfs(0,adj,vis);
        return count;
    }
    public void dfs(int src,List<List<Pair>> adj,boolean[] vis)
    {
        vis[src]=true;
        for(Pair p:adj.get(src))
        {
            if(!vis[p.node])
            {
                if(p.dir==-1)
                    count++;
                dfs(p.node,adj,vis);
            }
        }
    }
}