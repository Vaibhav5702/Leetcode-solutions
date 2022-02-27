class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        if(time.length==1)
            return time[0]*(long)totalTrips;
        long maxTime=time[0]*(long)totalTrips;
        long low=0,high=maxTime;
        long minTime=Long.MAX_VALUE;
        while(low<high)
        {
            long mid=low+(high-low)/2;
            long count=0;
            for(int a:time)
            {
                count+=mid/a;
                
            }
            if(count>=totalTrips)
                {
                    high=mid;
                }
            else
                low=mid+1;
        }
        return high;
    }
}