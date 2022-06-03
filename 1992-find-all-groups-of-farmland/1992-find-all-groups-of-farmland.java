class Solution {
    public int[][] findFarmland(int[][] land) {
        int m=land.length,n=land[0].length;
        boolean[][] visited=new boolean[m][n];
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(land[i][j]==1&&!visited[i][j])
                {
                    int row=i,col=j;
                    while(row<m&&land[row][j]==1)
                    {
                        row++;
                    }
                    while(col<n&&land[i][col]==1)
                    {
                        col++;
                    }
                    setVisited(i,j,row,col,visited);
                    list.add(new int[]{i,j,row-1,col-1});
                }
            }
        }
        int[][] ans=new int[list.size()][4];
        for(int i=0;i<list.size();i++)
        {
            ans[i]=list.get(i);
        }
        return ans;
    }
    public void setVisited(int sr, int sc,int er,int ec,boolean[][] vis)
    {
        for(int i=sr;i<er;i++)
        {
            for(int j=sc;j<ec;j++)
            {
                vis[i][j]=true;
            }
        }
    }
}