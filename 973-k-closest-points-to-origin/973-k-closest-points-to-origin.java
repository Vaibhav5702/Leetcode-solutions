class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->diff(a,b));
        for(int[] point:points)
        {
            pq.offer(point);
        }
        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++)
        {
            ans[i]=pq.poll();
        }
        return ans;
    }
    public int diff(int[] a,int[] b)
    {
        return a[0]*a[0]+a[1]*a[1]-(b[0]*b[0]+b[1]*b[1]);
    }
}