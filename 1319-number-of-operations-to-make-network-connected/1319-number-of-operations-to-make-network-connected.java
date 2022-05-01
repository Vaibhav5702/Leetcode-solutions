class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(n>connections.length+1)
            return -1;
        List<List<Integer>> list=new ArrayList();
        for(int i=0;i<n;i++)
        {
            list.add(new ArrayList<Integer>());
        }
        for(int[] connection:connections)
        {
            list.get(connection[0]).add(connection[1]);
            list.get(connection[1]).add(connection[0]);
        }
        boolean[] vis=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                Queue<Integer> queue=new LinkedList();
                queue.offer(i);
                vis[i]=true;
                count++;
                while(!queue.isEmpty())
                {
                    int node=queue.poll();
                    for(int a:list.get(node))
                    {
                        if(!vis[a])
                        {
                            queue.offer(a);
                            vis[a]=true;
                        }
                    }
                }
            }
        }
        return count-1;
    }
}