class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int max[]=new int[satisfaction.length+1];
        int maxSum=0;
        for(int i=1;i<=satisfaction.length;i++)
        {
            max[i]=Integer.MIN_VALUE;
            for(int j=i;j>=1;j--)
            {
                max[j]=Math.max(max[j],max[j-1]+satisfaction[i-1]*j);
            }
        }
        for(int i=0;i<max.length;i++)
        {
            maxSum=Math.max(maxSum,max[i]);
        }
        return maxSum;
    }
}