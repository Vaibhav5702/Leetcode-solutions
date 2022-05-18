class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] outdegree=new int[numCourses];
        List<List<Integer>> adj=new ArrayList();
        List<Set<Integer>> list=new ArrayList();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList());
            list.add(new HashSet());
        }
        for(int[] prerequisite:prerequisites)
        {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            outdegree[prerequisite[0]]++;
        }
        Queue<Integer> queue=new LinkedList();
        for(int i=0;i<numCourses;i++)
        {
            if(outdegree[i]==0)
                queue.offer(i);
        }
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            Set<Integer> set=list.get(node);
            for(int i:adj.get(node))
            {
                list.get(i).add(node);
                list.get(i).addAll(set);
                outdegree[i]--;
                if(outdegree[i]==0)
                    queue.offer(i);
            }
        }
        List<Boolean> ans=new ArrayList();
        for(int[] query:queries)
        {
            if(list.get(query[0]).contains(query[1]))
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}