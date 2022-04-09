class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap();
        for(int num:nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->b[1]-a[1]);
        for(Map.Entry entry:map.entrySet())
        {
            pq.offer(new int[]{(int)entry.getKey(),(int)entry.getValue()});
        }
        int ans[]=new int[k];
        for(int i=0;i<k;i++)
        {
            ans[i]=pq.poll()[0];
        }
        return ans;
    }
}