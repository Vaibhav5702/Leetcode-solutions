class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum=0,count=0;
        int arr[]=new int[300001];
        arr[0]=1;
        for(int num:nums)
        {
            sum+=num;
            if(sum-goal>=0)
                count+=arr[sum-goal];
            arr[sum]++;
        }
        return count;
    }
}