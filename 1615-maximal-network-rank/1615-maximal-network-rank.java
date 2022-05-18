class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] set=new boolean[n][n];
        int[] degree=new int[n];
        for(int[] road:roads)
        {
            set[road[0]][road[1]]=true;
            set[road[1]][road[0]]=true;
            degree[road[0]]++;
            degree[road[1]]++;
        }
        int max=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                max=Math.max(max,check(i,j,set,degree));
            }
        }
        return max;
    }
    public int check(int u,int v,boolean[][] set,int[] degree)
    {
        int rank=degree[u]+degree[v];
        if(set[u][v])
        {
            rank--;
        }
        return rank;
    }
}