class Solution {
    public int minOperations(int[] nums) {
        int incr=0,maxDouble=0;
        for(int num:nums)
        {
            int count=0;
            while(num!=0)
            {
                if(num%2!=0)
                    incr++;
                count++;
                num/=2;
            }
            maxDouble=Math.max(maxDouble,count-1);
        }
        return incr+maxDouble;
    }
}