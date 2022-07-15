class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Long,Integer> map=new HashMap<>();
        int count=0;
        for(int num:nums1)
        {
            long pro=(long)num*num;
            map.put(pro,map.getOrDefault(pro,0)+1);
        }
        for(int i=0;i<nums2.length;i++)
        {
            for(int j=i+1;j<nums2.length;j++)
            {
                long pro=nums2[i]*(long)nums2[j];
                if(map.containsKey(pro))
                    count+=map.get(pro);
            }
        }
        map=new HashMap<>();
        for(int num:nums2)
        {
            long pro=(long)num*num;
            map.put(pro,map.getOrDefault(pro,0)+1);
        }
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=i+1;j<nums1.length;j++)
            {
                long pro=nums1[i]*(long)nums1[j];
                if(map.containsKey(pro))
                    count+=map.get(pro);
            }
        }
        return count;
    }
}