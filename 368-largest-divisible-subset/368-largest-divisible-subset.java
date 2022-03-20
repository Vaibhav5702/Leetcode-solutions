class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList();
        int maxSize=0,index=0;
        for(int i=0;i<nums.length;i++)
        {
            List<Integer> a=new ArrayList();
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]%nums[j]==0&&a.size()<list.get(j).size())
                {
                    a=new ArrayList(list.get(j));
                }
            }
            a.add(nums[i]);
            list.add(a);
            if(a.size()>maxSize)
            {
                maxSize=a.size();
                index=i;
            }
        }
        return list.get(index);
    }
}