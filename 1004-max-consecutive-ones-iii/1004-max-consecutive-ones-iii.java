class Solution {
    public int longestOnes(int[] nums, int k) {
        int count=0,i=0;
        List<Integer> list=new ArrayList();
        list.add(-1);
        for(i=0;i<nums.length&&count<k;i++)
        {
            if(nums[i]==0)
            {
                count++;
                list.add(i);
            }
        }
        int maxLen=0;
        for(;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                maxLen=Math.max(maxLen,i-1-list.get(0));
                list.add(i);
                list.remove(0);
            }
        }
        return Math.max(maxLen,nums.length-1-list.get(0));
    }
}