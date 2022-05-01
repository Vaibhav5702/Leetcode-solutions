class Solution {
    public boolean isBipartite(int[][] graph) {
        int colour[]=new int[graph.length];
        for(int i=0;i<colour.length;i++)
        {
            colour[i]=-1;
        }
        for(int i=0;i<graph.length;i++)
        {
            if(colour[i]==-1)
            {
                if(!bfs(i,graph,colour))
                    return false;
            }
        }
        return true;
    }
    public boolean bfs(int s,int[][] graph,int[] colour)
    {
        Queue<Integer> queue=new LinkedList();
        queue.add(s);
        colour[s]=0;
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            for(int a:graph[node])
            {
                if(colour[a]==-1)
                {
                    colour[a]=1-colour[node];
                    queue.offer(a);
                }
                else if(colour[a]==colour[node])
                    return false;
            }
        }
        return true;
    }
}