class Solution {
    public int maximumProduct(int[] nums, int k) {
        if(nums.length==1)
        {
            return nums[0]+k;
        }
        PriorityQueue<Integer> pq=new PriorityQueue();
        for(int num:nums)
        {
            pq.offer(num);
        }
        while(k>0)
        {
            int val=pq.poll();
            int incr=Math.min(k,pq.peek()+1-val);
            val+=incr;
            k-=incr;
            pq.offer(val);
        }
        long pro=1;
        while(!pq.isEmpty())
        {
            pro=(pro*pq.poll())%1000000007;
        }
        return (int) pro;
    }
}