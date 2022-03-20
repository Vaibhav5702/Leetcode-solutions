class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq=new PriorityQueue(Collections.reverseOrder());
        double sum=0;
        for(int num:nums)
        {
            pq.add((double)num);
            sum+=num;
        }
        double half=sum;
        sum/=2;
        int count=0;
        while(half>sum)
        {
            double p=pq.poll()/2;
            half-=p;
            pq.offer(p);
            count++;
        }
        return count;
    }
}