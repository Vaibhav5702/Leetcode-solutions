class Solution {
    public boolean containsCycle(char[][] grid) {
        int[][] vis=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(vis[i][j]==0&&dfs(i,j,0,grid[i][j],grid,vis))
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(int r,int c,int len,char ch,char[][] grid,int[][] vis)
    {
        if(r<0||c<0||r==grid.length||c==grid[0].length||grid[r][c]!=ch)
            return false;
        if(vis[r][c]!=0)
        {
            return len-vis[r][c]>=4;
        }
        vis[r][c]=len;
        if(dfs(r-1,c,len+1,ch,grid,vis))
            return true;
        if(dfs(r,c-1,len+1,ch,grid,vis))
            return true;
        if(dfs(r+1,c,len+1,ch,grid,vis))
            return true;
        if(dfs(r,c+1,len+1,ch,grid,vis))
            return true;
        return false;
    }
}