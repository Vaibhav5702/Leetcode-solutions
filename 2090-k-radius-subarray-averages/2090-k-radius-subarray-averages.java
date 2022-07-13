class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] avg=new int[nums.length];
        int  len=2*k+1;
        if(nums.length<len)
        {
            for(int i=0;i<nums.length;i++)
            {
                avg[i]=-1;
            }
            return avg;
        }
        for(int i=0,j=nums.length-1;i<k;i++,j--)
        {
            avg[i]=-1;
            avg[j]=-1;
        }
        long sum=0;
        for(int i=0;i<len;i++)
        {
            sum+=nums[i];
        }
        avg[len-k-1]=(int)(sum/len);
        for(int i=len;i<nums.length;i++)
        {
            sum-=nums[i-len];
            sum+=nums[i];
            avg[i-k]=(int)(sum/len);
        }
        return avg;
    }
}