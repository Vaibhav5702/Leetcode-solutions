class Solution {
    public int minSetSize(int[] arr) {
        int num[]=new int[100001];
        PriorityQueue<Integer> pQueue
            = new PriorityQueue<Integer>(
                Collections.reverseOrder());
        for(int i:arr)
        {
            num[i]++;
        }
        for(int i:num)
        {
            if(i!=0)
                pQueue.add(i);
        }
        int count=0,rem=arr.length;
        while(!pQueue.isEmpty())
        {
            rem-=pQueue.poll();
            count++;
            if(rem<=arr.length/2)
                return count;
        }
        return count;
    }
}