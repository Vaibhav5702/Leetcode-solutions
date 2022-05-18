class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<Set<Integer>> list=new ArrayList();
        for(int i=0;i<n;i++)
        {
            list.add(new HashSet());
        }
        for(int[] road:roads)
        {
            list.get(road[0]).add(road[1]);
            list.get(road[1]).add(road[0]);
        }
        int max=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                max=Math.max(max,check(i,j,list));
            }
        }
        return max;
    }
    public int check(int u,int v,List<Set<Integer>> list)
    {
        int rank=list.get(u).size()+list.get(v).size();
        if(list.get(u).contains(v))
        {
            rank--;
        }
        return rank;
    }
}