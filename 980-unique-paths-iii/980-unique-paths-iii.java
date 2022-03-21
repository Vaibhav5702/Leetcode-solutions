class Solution {
    int count=0;
    public int uniquePathsIII(int[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int sr=0,sc=0,er=0,ec=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0)
                {
                    continue;
                }
                else if(grid[i][j]==-1)
                {
                    visited[i][j]=true;
                }
                else if(grid[i][j]==1)
                {
                    sr=i;
                    sc=j;
                }
                else
                {
                    er=i;
                    ec=j;
                }
            }
        }
        checkPath(sr,sc,er,ec,visited);
        return count;
    }
    public void checkPath(int r,int c,int er,int ec,boolean[][] visited)
    {
        if(r<0||r>=visited.length||c<0||c>=visited[0].length||visited[r][c])
            return;
        if(r==er&&c==ec)
        {
            visited[er][ec]=true;
            for(int i=0;i<visited.length;i++)
            {
                for(int j=0;j<visited[0].length;j++)
                {
                    if(!visited[i][j])
                    {
                        
                        visited[er][ec]=false;
                        return;
                    }
                }
            }
            visited[er][ec]=false;
            count++;
            return;
        }
        visited[r][c]=true;
        checkPath(r-1,c,er,ec,visited);
        checkPath(r+1,c,er,ec,visited);
        checkPath(r,c-1,er,ec,visited);
        checkPath(r,c+1,er,ec,visited);
        visited[r][c]=false;
    }
}