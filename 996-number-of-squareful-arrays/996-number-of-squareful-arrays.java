class Solution {
    int count=0;
    public int numSquarefulPerms(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (!counter.containsKey(num))
                counter.put(num, 0);
            counter.put(num, counter.get(num) + 1);
        }
        dfs(0,nums.length,counter,-1);
        return count;
    }
    public void dfs(int index,int n,Map<Integer,Integer> map,int prev)
    {
        if(index==n)
            count++;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0)
                continue;
            if(prev==-1||check(prev,num))
            {
                map.put(num, count - 1);
                dfs(index+1, n, map, num);
                map.put(num, count);
            }
        }
    }
    public boolean check(int i,int j)
    {
        int val=i+j;
        int sqrt=(int)Math.sqrt(val);
        if(sqrt*sqrt==val)
            return true;
        else return false;
    }
}