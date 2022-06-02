class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int indegree[]=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges)
        {
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> queue=new LinkedList();
        List<Set<Integer>> list=new ArrayList();
        for(int i=0;i<n;i++)
        {
            list.add(new HashSet<>());
            if(indegree[i]==0)
                queue.offer(i);
        }
        while(!queue.isEmpty())
        {
            int i=queue.poll();
            for(int e:adj.get(i))
            {
                list.get(e).addAll(list.get(i));
                list.get(e).add(i);
                indegree[e]--;
                if(indegree[e]==0)
                    queue.offer(e);
            }
        }
        List<List<Integer>> ans=new ArrayList();
        for(int i=0;i<n;i++)
        {
            List<Integer> node=new ArrayList(list.get(i));
            Collections.sort(node);
            ans.add(node);
        }
        return ans;
    }
}