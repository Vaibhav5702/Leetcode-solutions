class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list=new ArrayList();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            list.add(new ArrayList<Integer>());
        }
        for(int[] pre:prerequisites)
        {
            list.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }
        Queue<Integer> queue=new LinkedList();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
                queue.offer(i);
        }
        int[] arr=new int[numCourses];
        int index=numCourses-1;
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            arr[index--]=node;
            for(int i:list.get(node))
            {
                indegree[i]--;
                if(indegree[i]==0)
                    queue.offer(i);
            }
        }
        return index>0?new int[]{}:arr;
    }
}