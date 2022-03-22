class Solution {
    public long numberOfWeeks(int[] milestones) {
        long sum=0;
        int max=-1;
        for(int milestone:milestones)
        {
            sum+=milestone;
            max=Math.max(max,milestone);
        }
        sum-=max;
        if(sum>=max-1)
        {
            return sum+max;
        }
        return sum*2+1;
    }
}