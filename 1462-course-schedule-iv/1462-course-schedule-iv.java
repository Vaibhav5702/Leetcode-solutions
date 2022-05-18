class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] outdegree=new int[numCourses];
        List<List<Integer>> adj=new ArrayList();
        boolean[][] set=new boolean[numCourses][numCourses];
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList());
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
            for(int i:adj.get(node))
            {
                set[i][node]=true;
                for(int j=0;j<numCourses;j++)
                {
                    if(set[node][j])
                        set[i][j]=true;
                }
                outdegree[i]--;
                if(outdegree[i]==0)
                    queue.offer(i);
            }
        }
        List<Boolean> ans=new ArrayList();
        for(int[] query:queries)
        {
            if(set[query[0]][query[1]])
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}