class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap();
        for(int num:nums1)
        {
            map.put(num,1);
        }
        List<Integer> list2=new ArrayList();
        for(int num:nums2)
        {
            if(map.containsKey(num))
                map.put(num,-2);
            else
            {
                map.put(num,-2);
                list2.add(num);
            }
        }
        List<Integer> list1=new ArrayList();
        for(Map.Entry entry:map.entrySet())
        {
            if((int)entry.getValue()>0)
            list1.add((int)entry.getKey());
        }
        List<List<Integer>> list=new ArrayList();
        list.add(list1);
        list.add(list2);
        return list;
    }
}