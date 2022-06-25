class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] freq=new int[nums.length];
        for(int[] request:requests)
        {
            freq[request[0]]++;
            if(request[1]!=nums.length-1)
                freq[request[1]+1]--;
        }
        int sum=0;
        for(int i=0;i<freq.length;i++)
        {
            sum+=freq[i];
            freq[i]=sum;
        }
        Arrays.sort(nums);
        Arrays.sort(freq);
        long total=0;
        for(int i=nums.length-1;i>=0;i--)
        {
            if(freq[i]==0)
                break;
            total=(total+(long)freq[i]*nums[i])%1000000007;
        }
        return (int)total;
    }
}