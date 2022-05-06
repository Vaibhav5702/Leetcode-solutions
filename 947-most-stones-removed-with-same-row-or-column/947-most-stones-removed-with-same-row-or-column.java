class Solution {
    public int removeStones(int[][] stones) {
        Map<int[],List<int[]>> map=new HashMap();
        for(int i=0;i<stones.length;i++)
        {
            map.put(stones[i],new ArrayList<>());
        }
        for(int i=0;i<stones.length;i++)
        {
            
            for(int j=i+1;j<stones.length;j++)
            {
                if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1])
                {
                    map.get(stones[i]).add(stones[j]);
                    map.get(stones[j]).add(stones[i]);
                }
            }
        }
        Set<int[]> set=new HashSet();
        int count=0;
        for(int[] stone:stones)
        {
            if(!set.contains(stone))
            {
                count++;
                dfs(stone,set,map);
            }
            
        }
        return stones.length-count;
    }
    public void dfs(int[] stone,Set<int[]> set,Map<int[],List<int[]>> map)
    {
        set.add(stone);
        for(int[] s:map.get(stone))
        {
            if(!set.contains(s))
                dfs(s,set,map);
        }
    }
}