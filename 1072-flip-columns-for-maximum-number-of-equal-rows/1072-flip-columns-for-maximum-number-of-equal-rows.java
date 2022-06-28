class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String,Integer> map=new HashMap();
        int max=0;
        for(int[] arr:matrix)
        {
            StringBuilder org=new StringBuilder();
            StringBuilder flip=new StringBuilder();
            for(int num:arr)
            {
                org.append(num);
                flip.append(num==0?1:0);
            }
            String s1=org.toString();
            String s2=flip.toString();
            if(map.containsKey(s1))
                map.put(s1,map.get(s1)+1);
            else if(map.containsKey(s2))
                map.put(s2,map.get(s2)+1);
            else
                map.put(s1,1);
        }
        for(Map.Entry e:map.entrySet())
        {
            max=Math.max(max,(int)e.getValue());
        }
        return max;
    }
}