class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length)
            return -1;
        int maxDay=0;
        for(int day:bloomDay)
        {
            maxDay=Math.max(maxDay,day);
        }
        int low=0,high=maxDay;
        while(low<high)
        {
            int mid=(low+high)/2;
            if(possible(mid,bloomDay,m,k))
                high=mid;
            else
                low=mid+1;
        }
        return high;
    }
    public boolean possible(int days, int[] bloomDay, int m,int k)
    {
        int count=0,cBouquet=0;
        for(int i=0;i<bloomDay.length;i++)
        {
            if(days>=bloomDay[i])
                count++;
            else
                count=0;
            if(count==k)
            {
                cBouquet++;
                count=0;
            }
        }
        return cBouquet>=m;
    }
}