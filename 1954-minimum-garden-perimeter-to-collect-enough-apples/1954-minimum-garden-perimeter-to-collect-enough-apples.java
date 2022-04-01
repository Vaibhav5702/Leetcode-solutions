class Solution {
    public long minimumPerimeter(long neededApples) {
        long low=1,high=1000000;
        while(low<high)
        {
            long mid=(low+high)/2;
            long apple=calculateApples(mid);
            if(apple>=neededApples)
            {
                high=mid;
            }
            else
            {
                low=mid+1;
            }
        }
        return high*8;
    }
    public long calculateApples(long mid)
    {
        long sum=(mid*(mid+1))/2;
        sum=sum*(2*mid+1);
        sum=sum*4;
        return sum;
    }
}