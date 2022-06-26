class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int z=cardPoints.length-k;
        int sum=0;
        for(int card:cardPoints)
        {
            sum+=card;
        }
        int minSum=0,wSum=0;
        for(int i=0;i<z;i++)
        {
            minSum+=cardPoints[i];
        }
        wSum=minSum;
        for(int i=z;i<cardPoints.length;i++)
        {
            wSum+=cardPoints[i]-cardPoints[i-z];
            minSum=Math.min(minSum,wSum);
        }
        return sum-minSum;
    }
}