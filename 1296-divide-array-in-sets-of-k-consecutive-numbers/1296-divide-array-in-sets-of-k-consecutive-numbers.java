class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0)
            return false;
        Map<Integer,Queue<Integer>> map=new HashMap();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                Queue<Integer> list=new LinkedList();
                list.offer(i);
                map.put(nums[i],list);
            }
            else
            {
                map.get(nums[i]).offer(i);
            }
        }
        boolean visited[]=new boolean[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(visited[i])
                continue;
            int count=0;
            int val=nums[i];
            while(map.containsKey(val)&&count<k)
            {
                count++;
                int index=map.get(val).poll();
                if(map.get(val).isEmpty())
                    map.remove(val);
                val++;
                visited[index]=true;
            }
            if(count!=k)
                return false;
        }
        return true;
    }
}