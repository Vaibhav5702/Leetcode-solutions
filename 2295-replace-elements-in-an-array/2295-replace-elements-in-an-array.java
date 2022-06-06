class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],i);
        }
        for(int[] op:operations)
        {
            int idx=map.get(op[0]);
            map.put(op[1],idx);
            map.remove(op[0]);
        }
        int[] ans=new int[nums.length];
        for(Map.Entry e:map.entrySet())
        {
            ans[(int)e.getValue()]=(int)e.getKey();
        }
        return ans;
    }
}