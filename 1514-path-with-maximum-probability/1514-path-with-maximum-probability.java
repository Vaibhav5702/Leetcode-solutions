class Solution {
    public class Pair{
        int node;
        double val;
        Pair(int node,double val)
        {
            this.node=node;
            this.val=val;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj=new ArrayList();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int[] edge=edges[i];
            adj.get(edge[0]).add(new Pair(edge[1],succProb[i]));
            adj.get(edge[1]).add(new Pair(edge[0],succProb[i]));
        }
        double[] path=new double[n];
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b)
            {
                if(b.val>a.val)
                    return 1;
                else return -1;
            }
        });
        pq.offer(new Pair(start,1));
        path[start]=1;
        while(!pq.isEmpty())
        {
            Pair p=pq.poll();
            if(p.node==end)
                return p.val;
            for(Pair pr:adj.get(p.node))
            {
                if(path[pr.node]<p.val*pr.val)
                {
                    path[pr.node]=p.val*pr.val;
                    pq.offer(new Pair(pr.node,path[pr.node]));
                }
            }
        }
        return path[end];
    }
}