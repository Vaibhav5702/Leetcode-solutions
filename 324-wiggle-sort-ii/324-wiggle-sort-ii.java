class Solution {
    public void wiggleSort(int[] nums) {
        int[] arr=nums.clone();
        Arrays.sort(arr);
        int even=(nums.length-1)/2,odd=nums.length-1;
        int i=0;
        int x=nums.length%2==0?0:1;
        for(;even>=x;)
        {
            nums[i++]=arr[even--];
            nums[i++]=arr[odd--];
        }
        if(nums.length%2!=0)
            nums[i]=arr[even];
    }
}