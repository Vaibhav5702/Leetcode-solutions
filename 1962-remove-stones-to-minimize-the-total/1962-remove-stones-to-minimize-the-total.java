class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue(Collections.reverseOrder());
        for(int pile:piles)
        {
            pq.offer(pile);
        }
        for(int i=1;i<=k;i++)
        {
            int a=pq.poll();
            pq.offer(a-a/2);
        }
        int sum=0;
        while(!pq.isEmpty())
        {
            sum+=pq.poll();
        }
        return sum;
    }
}