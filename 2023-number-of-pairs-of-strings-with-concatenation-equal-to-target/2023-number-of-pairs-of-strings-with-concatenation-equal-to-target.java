class Solution {
    public int numOfPairs(String[] nums, String target) {
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(!target.startsWith(nums[i]))
                continue;
            for(int j=0;j<nums.length;j++)
            {
                if(i==j)
                    continue;
                if(nums[i].length()+nums[j].length()==target.length()&& target.equals(nums[i]+nums[j]))
                    count++;
            }
        }
        return count;
    }
}