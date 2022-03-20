class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int size[]=new int[nums.length];
        int indexes[]=new int[nums.length];
        size[0]=1;
        indexes[0]=-1;
        int maxSize=1,index=0;
        for(int i=1;i<nums.length;i++)
        {
            indexes[i]=-1;
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]%nums[j]==0&&size[i]<size[j])
                {
                    size[i]=size[j];
                    indexes[i]=j;
                }
            }
            size[i]++;
            if(size[i]>maxSize)
            {
                maxSize=size[i];
                index=i;
            }
        }
        List<Integer> list=new ArrayList();
        do
        {
            list.add(nums[index]);
            index=indexes[index];
        }while(index!=-1);
        return list;
    }
}