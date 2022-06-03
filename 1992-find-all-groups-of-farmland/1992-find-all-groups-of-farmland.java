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
                        for(int k=i;k<row;k++)
                            visited[k][col]=true;
                        col++;
                    }
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
}