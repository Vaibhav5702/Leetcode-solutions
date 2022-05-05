class Solution {
    public class Pair
    {
        int v,w;
        Pair(int v,int w)
        {
            this.v=v;
            this.w=w;
        }
        
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] time:times)
        {
            adj.get(time[0]).add(new Pair(time[1],time[2]));
        }
        int[] arr=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            arr[i]=Integer.MAX_VALUE;
        }
        arr[k]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.w-b.w);
        pq.offer(new Pair(k,0));
        while(!pq.isEmpty())
        {
            Pair a=pq.poll();
            int v=a.v;
            int w=a.w;
            for(Pair p:adj.get(v))
            {
                if(w+p.w<arr[p.v])
                {
                    arr[p.v]=w+p.w;
                    pq.offer(new Pair(p.v,arr[p.v]));
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++)
        {
            max=Math.max(max,arr[i]);
        }
        return max==Integer.MAX_VALUE?-1:max;
    }
}