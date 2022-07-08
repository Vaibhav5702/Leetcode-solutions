class Solution {
    class Pair
    {
        int i,j,dist;
        Pair(int i, int j, int dist)
        {
            this.i=i;
            this.j=j;
            this.dist=dist;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        for(int i=0;i<points.length;i++)
        {
            for(int j=i+1;j<points.length;j++)
            {
                int distance=Math.abs(points[i][0]-points[j][0])+
                    Math.abs(points[i][1]-points[j][1]);
                pq.offer(new Pair(i,j,distance));
            }
        }
        int[] parent=new int[points.length];
        for(int i=0;i<parent.length;i++)
        {
            parent[i]=i;
        }
        int count=0,sum=0;
        while(!pq.isEmpty())
        {
            Pair p=pq.poll();
            if(union(p.i,p.j,parent)){
                
                sum+=p.dist;
                count++;
            }
            if(count==points.length-1)
                break;
        }
        return sum;
    }
    public boolean union(int i,int j,int[] parent){
        i=find(i,parent);
        j=find(j,parent);
        if(i==j)
            return false;
        parent[i]=j;
        return true;
    }
    public int find(int i,int[] parent)
    {
        if(i==parent[i])
            return i;
        parent[i]=find(parent[i],parent);
        return parent[i];
    }
}