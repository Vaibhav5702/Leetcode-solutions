class Solution {
    public List<String> summaryRanges(int[] nums) {
        int left=0;
        List<String> list=new ArrayList();
        if(nums.length==0)
            return list;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]!=nums[i-1]+1)
            {
                if(left==i-1)
                    list.add(nums[left]+"");
                else
                    list.add(nums[left]+"->"+nums[i-1]);
                left=i;
            }
        }
        if(left==nums.length-1)
            list.add(nums[left]+"");
        else
            list.add(nums[left]+"->"+nums[nums.length-1]);
        return list;
        
    }
}