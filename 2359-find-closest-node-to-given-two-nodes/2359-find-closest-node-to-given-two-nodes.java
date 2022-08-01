class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if(node1==node2)
            return node1;
        int n=edges.length;
        int[] dis1=new int[n];
        int[] dis2=new int[n];
        getDist(node1,dis1,edges);
        getDist(node2,dis2,edges);
        int min=Integer.MAX_VALUE,minNode=-1;
        for(int i=0;i<n;i++)
        {
            if(dis1[i]>-1&&dis2[i]>-1&&min>Math.max(dis1[i],dis2[i]))
            {
                min=Math.max(dis1[i],dis2[i]);
                minNode=i;
            }
        }
        return minNode;
    }
    public void getDist(int node,int[] dis,int[] edges)
    {
        
        for(int i=0;i<edges.length;i++)
        {
            dis[i]=-1;
        }
        int dist=0;
        do{
            dis[node]=dist++;
            node=edges[node];
        }while(node!=-1&&dis[node]==-1);
    }
}